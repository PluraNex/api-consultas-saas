package com.pluranex.api_consulta_saas.domain.notificacao.usecase

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.validation.NotificacaoValidator
import com.pluranex.api_consulta_saas.infrastructure.providers.NotificationProviderFactory
import org.springframework.stereotype.Component

@Component
class ReenviarNotificacao(
    private val providerFactory: NotificationProviderFactory,
    private val notificacaoValidator: NotificacaoValidator
) {

    fun executar(
        notificacao: Notificacao,
        canal: CanalNotificacao,
        maxAttempts: Int = 3,
        retryDelayMs: Long = 2000
    ) {
        notificacaoValidator.validarStatusParaReenvio(notificacao)

        val provider = providerFactory.getProvider(canal)
        var attempt = 0

        while (attempt < maxAttempts) {
            try {
                provider.enviar(notificacao)
                return
            } catch (e: Exception) {
                attempt++
                if (attempt >= maxAttempts) {
                    throw IntegrationException(
                        ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO,
                        "Erro ao integrar com o serviço $canal ao reenviar a notificação com ID ${notificacao.id} após $attempt tentativas: ${e.message}"
                    )
                }
                Thread.sleep(retryDelayMs)
            }
        }
    }
}
