package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_REMOVER_CONFIGURACAO
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.CONFIGURACAO_NOT_FOUND
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RemoverConfiguracaoNotificacao(
    private val configuracaoRepository: ConfiguracaoNotificacaoRepository
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(RemoverConfiguracaoNotificacao::class.java)
    }

    fun execute(id: Long) {

         configuracaoRepository.buscarConfiguracaoPorId(id)
            ?: throw NotFoundException(
                CONFIGURACAO_NOT_FOUND,
                "Configuração de notificação com ID $id não encontrada."
            )

        if (configuracaoRepository.isConfiguracaoEmUso(id)) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.CONFIGURACAO_EM_USO,
                "A configuração de notificação com ID $id não pode ser removida, pois está sendo usada por notificações existentes."
            )
        }

        try {
            configuracaoRepository.removerConfiguracao(id).also {
                logger.info("Configuração de notificação com ID $id removida com sucesso.")
            }
        } catch (e: Exception) {
            logger.error("Erro ao remover a configuração de notificação com ID $id: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_REMOVER_CONFIGURACAO,
                "Erro ao remover a configuração de notificação com ID $id.",
                e
            )
        }
    }
}
