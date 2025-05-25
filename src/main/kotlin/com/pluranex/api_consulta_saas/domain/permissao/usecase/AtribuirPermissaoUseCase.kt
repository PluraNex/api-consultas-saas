package com.pluranex.api_consulta_saas.domain.permissao.usecase

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.permissao.PermissaoRepository
import com.pluranex.api_consulta_saas.domain.permissao.PermissaoUsuario
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AtribuirPermissaoUseCase(
    private val permissaoRepository: PermissaoRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(AtribuirPermissaoUseCase::class.java)
    }

    fun executar(usuarioId: Long, permissao: PermissaoUsuario): PermissaoUsuario {
        return try {
            permissaoRepository.salvar(permissao).also {
                logger.info("Permissão '${permissao.permissao}' atribuída com sucesso ao usuário $usuarioId")
            }
        } catch (e: Exception) {
            logger.error("Erro ao atribuir permissão '${permissao.permissao}' ao usuário $usuarioId", e)
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_ATRIBUIR_PERMISSAO,
                "Erro ao atribuir permissão ao usuário $usuarioId",
                e
            )
        }
    }
}
