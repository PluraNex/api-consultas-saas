package com.pluranex.api_consulta_saas.domain.procedimento.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_PROCEDIMENTO
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.repository.ProcedimentoRepository
import com.pluranex.api_consulta_saas.domain.procedimento.validation.ProcedimentoValidator
import org.slf4j.LoggerFactory

/**
 * Caso de uso responsável por orquestrar a criação de um novo procedimento.
 *
 * Valida as regras de negócio e persiste a entidade no repositório.
 */
@UseCase
class CriarProcedimentoUseCase(
    private val procedimentoValidator: ProcedimentoValidator,
    private val procedimentoRepository: ProcedimentoRepository
) {

    private val logger = LoggerFactory.getLogger(CriarProcedimentoUseCase::class.java)

    /**
     * Executa o fluxo completo de criação do procedimento.
     *
     * @param procedimento Procedimento a ser criado.
     * @return Procedimento criado e persistido.
     * @throws IntegrationException caso ocorra falha ao salvar no repositório.
     */
    fun executar(procedimento: Procedimento): Procedimento {
        logger.info("Iniciando criação de procedimento: tipo=${procedimento.tipo}, nome=${procedimento.nome}")

        // Valida políticas e campos obrigatórios
        procedimentoValidator.validarCriacao(procedimento)

        return try {
            procedimentoRepository.salvar(procedimento).also {
                logger.info("Procedimento criado com sucesso. ID: ${it.id}")
            }
        } catch (ex: Exception) {
            logger.error("Erro ao criar procedimento: ${ex.message}", ex)
            throw IntegrationException(
                ERRO_AO_CRIAR_PROCEDIMENTO,
                "Erro ao criar procedimento '${procedimento.nome}'",
                ex
            )
        }
    }
}
