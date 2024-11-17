package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class EmailNotificationProvider : NotificationProvider {

    private val logger = LoggerFactory.getLogger(EmailNotificationProvider::class.java)

    override fun enviar(notificacao: Notificacao) {
        try {
            // Obter o destinatário do canal EMAIL
            val destinatario = notificacao.destinatarios[CanalNotificacao.EMAIL]
                ?: throw IntegrationException(
                    IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                    "Destinatário para o canal EMAIL não encontrado na notificação com ID ${notificacao.id}"
                )

            // Log de informação sobre o envio de e-mail
            logger.info("Enviando e-mail para $destinatario com a mensagem: '${notificacao.mensagem}'")

            // Lógica para envio de e-mail (ex.: usando JavaMail ou SendGrid)
        } catch (e: Exception) {
            logger.error("Erro ao enviar e-mail para a notificação com ID ${notificacao.id}: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                "Erro ao enviar e-mail: ${e.message}",
                e
            )
        }
    }
}
