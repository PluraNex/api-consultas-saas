package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.infrastructure.providers.NotificationProviderFactory
import org.springframework.stereotype.Component

@Component
class EnviarNotificacao(
    private val providerFactory: NotificationProviderFactory
) {

    fun executar(notificacao: Notificacao, canal: CanalNotificacao) {
        if (notificacao.status == StatusNotificacao.ENVIADA) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.NOTIFICACAO_JA_ENVIADA,
                "A notificação com ID ${notificacao.id} já foi enviada."
            )
        }

        try {
            val provider = providerFactory.getProvider(canal)
            provider.enviar(notificacao)
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.TWILIO_API_ERROR,
                "Erro ao enviar a notificação pelo canal $canal para a notificação com ID ${notificacao.id}: ${e.message}"
            )
        }
    }
}

