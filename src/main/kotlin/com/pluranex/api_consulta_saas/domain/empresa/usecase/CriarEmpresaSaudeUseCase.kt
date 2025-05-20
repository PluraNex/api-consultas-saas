package com.pluranex.api_consulta_saas.domain.empresa.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaudeRepository
import com.pluranex.api_consulta_saas.domain.empresa.validation.EmpresaSaudeValidator
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_EMPRESA_SAUDE
import org.slf4j.LoggerFactory

@UseCase
class CriarEmpresaSaudeUseCase(
    private val empresaSaudeRepository: EmpresaSaudeRepository,
    private val empresaSaudeValidator: EmpresaSaudeValidator
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CriarEmpresaSaudeUseCase::class.java)
    }

    fun executar(nome: String): EmpresaSaude {
        logger.info("Iniciando criação de empresa de saúde com nome: $nome")

        empresaSaudeValidator.validarNome(nome)

        return try {
            empresaSaudeRepository.salvar(EmpresaSaude(nome = nome)).also {
                logger.info("Empresa criada com sucesso. ID: ${it.id}")
            }
        } catch (e: Exception) {
            logger.error("Erro ao criar empresa de saúde: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_CRIAR_EMPRESA_SAUDE,
                "Erro ao criar empresa de saúde com nome: $nome",
                e
            )
        }
    }
}
