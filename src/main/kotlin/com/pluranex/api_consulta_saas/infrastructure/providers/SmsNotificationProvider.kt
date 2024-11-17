package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class SmsNotificationProvider : NotificationProvider {

    private val logger = LoggerFactory.getLogger(SmsNotificationProvider::class.java)

    override fun enviar(notificacao: Notificacao) {
        try {
            val destinatario = notificacao.destinatarios[CanalNotificacao.SMS]
                ?: throw IntegrationException(
                    IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                    "Destinatário para o canal SMS não encontrado na notificação com ID ${notificacao.id}"
                )

            logger.info("Enviando SMS para $destinatario com a mensagem: '${notificacao.mensagem}'")

            // Lógica para envio de SMS (ex.: usando Twilio ou Nexmo)
        } catch (e: Exception) {
            logger.error("Erro ao enviar SMS para a notificação com ID ${notificacao.id}: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                "Erro ao enviar SMS: ${e.message}",
                e
            )
        }
    }
}
