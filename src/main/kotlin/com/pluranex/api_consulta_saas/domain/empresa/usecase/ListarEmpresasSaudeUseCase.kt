package com.pluranex.api_consulta_saas.domain.empresa.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaudeRepository
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_LISTAR_EMPRESAS
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.EMPRESA_SAUDE_NOT_FOUND
import org.slf4j.LoggerFactory

@UseCase
class ListarEmpresasSaudeUseCase(
    private val empresaSaudeRepository: EmpresaSaudeRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(ListarEmpresasSaudeUseCase::class.java)
    }

    fun executar(): List<EmpresaSaude> {
        logger.info("Executando listagem de empresas de saúde")

        return try {
            empresaSaudeRepository.listarTodas()
                .takeIf { it.isNotEmpty() }
                ?: throw NotFoundException(
                    EMPRESA_SAUDE_NOT_FOUND,
                    "Nenhuma empresa de saúde encontrada no sistema."
                )
        } catch (e: Exception) {
            logger.error("Erro ao listar empresas de saúde: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_LISTAR_EMPRESAS,
                "Erro ao listar empresas de saúde: ${e.message}",
                e
            )
        }
    }
}
