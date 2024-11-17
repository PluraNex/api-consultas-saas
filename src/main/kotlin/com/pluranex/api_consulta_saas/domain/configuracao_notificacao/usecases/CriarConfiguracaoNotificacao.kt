package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.validation.ConfiguracaoValidator
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CriarConfiguracaoNotificacao(
    private val repository: ConfiguracaoNotificacaoRepository,
    private val configuracaoValidator: ConfiguracaoValidator
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(CriarConfiguracaoNotificacao::class.java)
    }

    fun execute(configuracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao {
        return try {

            configuracaoValidator.validarNovaConfiguracaoParaNotificacao(configuracao, notificacaoId)

            repository.criarConfiguracao(configuracao).also {
                logger.info("Configuração criada com sucesso para a notificação ID: $notificacaoId")
            }
        } catch (e: Exception) {
            logger.error("Erro ao criar configuração de notificação para a notificação com ID $notificacaoId: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_CONFIGURACAO,
                "Erro ao criar configuração de notificação para a notificação com ID: $notificacaoId.",
                e
            )
        }
    }
}
