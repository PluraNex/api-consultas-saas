package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ListarConfiguracoesNotificacao(
    private val repository: ConfiguracaoNotificacaoRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(ListarConfiguracoesNotificacao::class.java)
    }

    fun execute(): List<ConfiguracaoNotificacao> {
        return try {
            repository.listarConfiguracoes().also { configuracoes ->
                if (configuracoes.isEmpty()) {
                    throw NotFoundException(
                        NotFoundException.NotFoundExceptionType.CONFIGURACAO_NOT_FOUND,
                        "Nenhuma configuração de notificação encontrada no sistema."
                    )
                }
                logger.info("Listagem de configurações concluída com sucesso. Total encontrado: ${configuracoes.size}")
            }
        } catch (e: Exception) {
            logger.error("Erro ao listar configurações de notificação: ${e.message}", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_LISTAR_CONFIGURACOES,
                "Erro ao listar configurações de notificação.",
                e
            )
        }
    }
}
