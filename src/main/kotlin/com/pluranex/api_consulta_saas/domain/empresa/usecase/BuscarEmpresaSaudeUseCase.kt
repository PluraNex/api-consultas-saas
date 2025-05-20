package com.pluranex.api_consulta_saas.domain.empresa.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaudeRepository
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.EMPRESA_SAUDE_NOT_FOUND
import org.slf4j.LoggerFactory

@UseCase
class BuscarEmpresaSaudeUseCase(
    private val empresaSaudeRepository: EmpresaSaudeRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(BuscarEmpresaSaudeUseCase::class.java)
    }

    fun executar(id: Long): EmpresaSaude {
        logger.info("Executando busca da empresa de saúde com ID: $id")

        return empresaSaudeRepository.buscarPorId(id)
            ?: throw NotFoundException(
                EMPRESA_SAUDE_NOT_FOUND,
                "Empresa de saúde com ID $id não encontrada."
            )
    }
}
