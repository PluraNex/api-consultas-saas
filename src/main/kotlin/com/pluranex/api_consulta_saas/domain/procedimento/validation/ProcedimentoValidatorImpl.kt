package com.pluranex.api_consulta_saas.domain.procedimento.validation

import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import org.springframework.stereotype.Service

/**
 * Implementação principal da interface [ProcedimentoValidator].
 *
 * Essa classe coordena a execução dos validadores especializados
 * para garantir que os procedimentos atendam às políticas institucionais,
 * critérios de estado e integridade de dados obrigatórios.
 *
 * Também expõe funcionalidades auxiliares como a listagem de tipos permitidos
 * com base na política vigente do perfil da clínica atual.
 */
@Service
class ProcedimentoValidatorImpl (
) : ProcedimentoValidator {
    override fun validarCriacao(procedimento: Procedimento) {
        TODO("Not yet implemented")
    }
}