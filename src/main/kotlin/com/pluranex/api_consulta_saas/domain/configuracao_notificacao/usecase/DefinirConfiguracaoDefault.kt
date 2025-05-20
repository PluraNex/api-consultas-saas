package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecase

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.validation.ConfiguracaoValidator
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DefinirConfiguracaoDefault(
    private val repository: ConfiguracaoNotificacaoRepository,
    private val configuracaoValidator: ConfiguracaoValidator
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(DefinirConfiguracaoDefault::class.java)
    }

    fun executar(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacao {
        return try {
            // Valida a configuração
            configuracaoValidator.validarCanaisAtivos(configuracao.canaisAtivos)
            configuracaoValidator.validarDataAgendada(configuracao.agendadaPara)

            // Remove a marcação de default da configuração atual, se existir
            val configuracaoAtual = repository.findFirstByIsDefaultTrue()
            configuracaoAtual?.let {
                val configuracaoAtualizada = it.copy(
                    isDefault = false,
                    canaisAtivos = it.canaisAtivos.toMutableList() // Cria uma nova instância da lista
                )
                repository.criarConfiguracao(configuracaoAtualizada)
                logger.info("Configuração default anterior desmarcada: ID ${it.id}")
            }

            // Define a nova configuração como default
            val novaConfiguracao = configuracao.copy(
                isDefault = true,
                canaisAtivos = configuracao.canaisAtivos.toMutableList() // Cria uma nova instância da lista
            )
            val configuracaoSalva = repository.criarConfiguracao(novaConfiguracao)

            logger.info("Nova configuração default definida com sucesso: ID ${configuracaoSalva.id}")
            configuracaoSalva
        } catch (e: Exception) {
            logger.error("Erro ao definir configuração default: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_CONFIGURACAO,
                "Erro ao definir configuração default.",
                e
            )
        }
    }
}
