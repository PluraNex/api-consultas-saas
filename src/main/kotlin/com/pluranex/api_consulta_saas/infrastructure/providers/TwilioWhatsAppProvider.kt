package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.infrastructure.clients.TwilioFeignClient
import com.pluranex.api_consulta_saas.infrastructure.responses.TwilioResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TwilioWhatsAppProvider(
    private val twilioClient: TwilioFeignClient
) : NotificationProvider {

    private val logger = LoggerFactory.getLogger(TwilioWhatsAppProvider::class.java)

    override fun enviar(notificacao: Notificacao) {
        try {
            // Obter o destinatário do canal WHATSAPP
            val destinatario = notificacao.destinatarios[CanalNotificacao.WHATSAPP]
                ?: throw IntegrationException(
                    IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                    "Destinatário para o canal WHATSAPP não encontrado na notificação com ID ${notificacao.id}"
                )

            // Log de informação sobre o envio da mensagem
            logger.info("Enviando mensagem via Twilio para $destinatario com a mensagem: '${notificacao.mensagem}'")

            // Chamar o cliente Feign para enviar a mensagem
            val response = twilioClient.enviarMensagem(
                destinatario = destinatario,
                remetente = System.getenv("TWILIO_PHONE_NUMBER"),
                mensagem = notificacao.mensagem
            )

            // Validar a resposta do Twilio
            validarResposta(response)
        } catch (e: Exception) {
            logger.error("Erro ao integrar com o serviço Twilio para a notificação com ID ${notificacao.id}: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                "Erro ao integrar com o serviço Twilio: ${e.message}",
                e
            )
        }
    }

    private fun validarResposta(response: TwilioResponse) {
        if (response.status !in listOf("queued", "sent")) {
            val errorMessage = response.errorMessage ?: "Erro desconhecido"
            logger.error("Falha ao enviar mensagem via Twilio: $errorMessage")
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                "Falha ao enviar mensagem via Twilio: $errorMessage"
            )
        } else {
            logger.info("Mensagem enviada com sucesso via Twilio. Status: ${response.status}")
        }
    }
}
