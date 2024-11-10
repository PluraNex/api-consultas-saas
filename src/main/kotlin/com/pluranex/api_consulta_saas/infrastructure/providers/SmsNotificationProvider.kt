package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Service

@Service
class SmsNotificationProvider : NotificationProvider {

    override fun enviar(notificacao: Notificacao) {
        try {
            // Lógica para envio de SMS (ex.: usando Twilio ou Nexmo)
            println("Enviando SMS para ${notificacao.destinatario}")
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.API_EXTERNA_INDISPONIVEL,
                "Erro ao enviar SMS: ${e.message}"
            )
        }
    }
}