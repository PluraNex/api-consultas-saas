package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.infrastructure.clients.TwilioFeignClient
import com.pluranex.api_consulta_saas.infrastructure.responses.TwilioResponse
import org.springframework.stereotype.Service

@Service
class TwilioWhatsAppProvider(
    private val twilioClient: TwilioFeignClient
) : NotificationProvider {

    override fun enviar(notificacao: Notificacao) {
        try {
            val response = twilioClient.enviarMensagem(
                destinatario = notificacao.destinatario,
                remetente = System.getenv("TWILIO_PHONE_NUMBER"),
                mensagem = notificacao.mensagem
            )

            validarResposta(response)
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.TWILIO_API_ERROR,
                "Erro ao integrar com o serviço Twilio para a notificação com ID ${notificacao.id}: ${e.message}"
            )
        }
    }

    private fun validarResposta(response: TwilioResponse) {
        if (response.status !in listOf("queued", "sent")) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.API_EXTERNA_INDISPONIVEL,
                "Falha ao enviar mensagem via Twilio: ${response.errorMessage ?: "Erro desconhecido"}"
            )
        }
    }
}

