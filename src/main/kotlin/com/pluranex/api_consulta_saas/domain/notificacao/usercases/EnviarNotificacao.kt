package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.validation.NotificacaoValidator
import com.pluranex.api_consulta_saas.infrastructure.providers.NotificationProviderFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class EnviarNotificacao(
    private val providerFactory: NotificationProviderFactory,
    private val notificacaoValidator: NotificacaoValidator
) {

    companion object {
        private val logger = LoggerFactory.getLogger(EnviarNotificacao::class.java)
    }

    fun executar(notificacao: Notificacao, canal: CanalNotificacao) {

        try {

            notificacaoValidator.validarNotificacaoExistente(notificacao)
            notificacaoValidator.validarStatusParaEnvio(notificacao)
            notificacaoValidator.validarCanal(canal)
            notificacaoValidator.validarCanalAtivoNaConfiguracao(notificacao, canal)

            val provider = providerFactory.getProvider(canal)
            provider.enviar(notificacao).also {
                logger.info("Notificação com ID: ${notificacao.id} enviada com sucesso pelo canal: $canal")
            }
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.TWILIO_API_ERROR,
                "Erro ao enviar a notificação pelo canal $canal para a notificação com ID ${notificacao.id}.",
                e
            )
        }
    }
}

