package com.pluranex.api_consulta_saas.domain.procedimento.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_PROCEDIMENTO
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.ProcedimentoRepository
import com.pluranex.api_consulta_saas.domain.procedimento.validation.ProcedimentoValidator
import org.slf4j.LoggerFactory

/**
 * Caso de uso responsável por orquestrar a criação de um novo procedimento.
 *
 * Valida as políticas da clínica, os dados obrigatórios e persiste a entidade.
 */
@UseCase
class CriarProcedimentoUseCase(
    private val procedimentoValidator: ProcedimentoValidator,
    private val procedimentoRepository: ProcedimentoRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CriarProcedimentoUseCase::class.java)
    }

    /**
     * Executa o fluxo completo de criação do procedimento.
     *
     * @param procedimento Procedimento a ser criado.
     * @param clinica Clínica da sessão, utilizada para validar o contexto.
     *
     * @throws IntegrationException caso ocorra falha ao persistir.
     */
    fun executar(procedimento: Procedimento, clinica: Clinica): Procedimento {
        logger.info("Iniciando criação de procedimento: tipo=${procedimento.tipo}, nome=${procedimento.nome}")

        procedimentoValidator.validarCriacao(procedimento, clinica)

        return try {
            procedimentoRepository.salvar(procedimento).also {
                logger.info("Procedimento criado com sucesso. ID: ${it.id}")
            }
        } catch (e: Exception) {
            logger.error("Erro ao criar procedimento: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_CRIAR_PROCEDIMENTO,
                "Erro ao criar procedimento '${procedimento.nome}' para a clínica '${clinica.id}'",
                e
            )
        }
    }
}
