package com.pluranex.api_consulta_saas.domain.procedimento.validation

import com.pluranex.api_consulta_saas.domain.procedimento.validation.policy.ProcedimentoPolicyValidator
import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.validation.rules.ProcedimentoCamposObrigatoriosValidator
import org.springframework.stereotype.Service

/**
 * Implementação principal da interface [ProcedimentoValidator].
 *
 * Essa classe coordena a execução dos validadores especializados
 * para garantir que os procedimentos atendam às políticas institucionais,
 * critérios de estado e integridade de dados obrigatórios.
 */
@Service
class ProcedimentoValidatorImpl(
    private val procedimentoPolicyValidator: ProcedimentoPolicyValidator,
    private val procedimentoCamposObrigatoriosValidator: ProcedimentoCamposObrigatoriosValidator,
) : ProcedimentoValidator {

    override fun validarCriacao(procedimento: Procedimento, clinica: Clinica) {
        validarPermissaoPolitica(procedimento, clinica)
        validarDadosObrigatorios(procedimento)
    }

    override fun validarEdicao(procedimento: Procedimento) {
        procedimentoPolicyValidator.validar(procedimento)
        procedimentoCamposObrigatoriosValidator.validar(procedimento)
    }

    override fun validarPermissaoPolitica(procedimento: Procedimento, clinica: Clinica) {
        procedimentoPolicyValidator.validar(procedimento)
    }

    override fun validarDadosObrigatorios(procedimento: Procedimento) {
        procedimentoCamposObrigatoriosValidator.validar(procedimento)
    }
}
