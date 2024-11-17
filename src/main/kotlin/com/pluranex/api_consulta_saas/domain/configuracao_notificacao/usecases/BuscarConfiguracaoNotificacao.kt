package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class BuscarConfiguracaoNotificacao(
    private val repository: ConfiguracaoNotificacaoRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(BuscarConfiguracaoNotificacao::class.java)
    }

    fun execute(id: Long): ConfiguracaoNotificacao {
        return try {
            repository.buscarConfiguracaoPorId(id)?.also {
                logger.info("Configuração de notificação encontrada para o ID: $id")
            } ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.CONFIGURACAO_NOT_FOUND,
                "Configuração de notificação com ID $id não encontrada."
            )
        } catch (e: Exception) {
            logger.error("Erro ao buscar configuração de notificação com ID $id: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_BUSCAR_CONFIGURACAO,
                "Erro ao buscar configuração de notificação com ID $id.",
                e
            )
        }
    }
}
