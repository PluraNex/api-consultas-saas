package com.pluranex.api_consulta_saas.infrastructure.communication

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import org.springframework.stereotype.Component

@Component
class NotificationProviderFactory(
    private val whatsappProvider: TwilioWhatsAppProvider,
    private val emailProvider: EmailNotificationProvider,
    private val smsProvider: SmsNotificationProvider
) {

    fun getProvider(canal: CanalNotificacao): NotificationProvider {
        return when (canal) {
            CanalNotificacao.WHATSAPP -> whatsappProvider
            CanalNotificacao.EMAIL -> emailProvider
            CanalNotificacao.SMS -> smsProvider
        }
    }
}

