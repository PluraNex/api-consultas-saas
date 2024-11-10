package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Service

@Service
class EmailNotificationProvider : NotificationProvider {

    override fun enviar(notificacao: Notificacao) {
        try {
            // Lógica para envio de email (ex.: usando JavaMail ou SendGrid)
            println("Enviando email para ${notificacao.destinatario}")
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.API_EXTERNA_INDISPONIVEL,
                "Erro ao enviar email: ${e.message}"
            )
        }
    }
}