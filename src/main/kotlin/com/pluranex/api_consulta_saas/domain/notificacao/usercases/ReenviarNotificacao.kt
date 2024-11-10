package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException.BusinessExceptionType.TIPO_NOTIFICACAO_INVALIDO
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.API_EXTERNA_INDISPONIVEL
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.infrastructure.providers.NotificationProviderFactory
import org.springframework.stereotype.Component

@Component
class ReenviarNotificacao(
    private val providerFactory: NotificationProviderFactory
) {

    fun executar(
        notificacao: Notificacao,
        canal: CanalNotificacao,
        maxAttempts: Int = 3,
        retryDelayMs: Long = 2000
    ) {
        if (notificacao.status != StatusNotificacao.FALHA) {
            throw BusinessException(
                TIPO_NOTIFICACAO_INVALIDO,
                "A notificação com ID ${notificacao.id} não está em estado de falha para ser reenviada."
            )
        }

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
                        API_EXTERNA_INDISPONIVEL,
                        "Erro ao integrar com o serviço $canal ao reenviar a notificação com ID ${notificacao.id} após $attempt tentativas: ${e.message}"
                    )
                }
                Thread.sleep(retryDelayMs)
            }
        }
    }
}
