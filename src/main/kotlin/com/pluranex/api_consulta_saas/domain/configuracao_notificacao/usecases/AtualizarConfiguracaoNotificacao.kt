package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.validation.ConfiguracaoValidator
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_ATUALIZAR_CONFIGURACAO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AtualizarConfiguracaoNotificacao(
    private val repository: ConfiguracaoNotificacaoRepository,
    private val configuracaoValidator: ConfiguracaoValidator
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(AtualizarConfiguracaoNotificacao::class.java)
    }

    fun execute(novaConfiguracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao {

        configuracaoValidator.validarNotificacaoExistente(notificacaoId)
        configuracaoValidator.validarNovaConfiguracaoParaNotificacao(novaConfiguracao, notificacaoId)

        return try {
            repository.atualizarConfiguracao(novaConfiguracao).also {
                logger.info("Configuração atualizada com sucesso para a notificação ID: $notificacaoId")
            }
        } catch (e: Exception) {
            throw IntegrationException(
                ERRO_AO_ATUALIZAR_CONFIGURACAO,
                "Erro ao atualizar configuração de notificação para a notificação com ID $notificacaoId: ${e.message}",
                e
            )
        }
    }
}
