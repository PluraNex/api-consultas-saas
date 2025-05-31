package com.pluranex.api_consulta_saas.domain.procedimento.policy.definition

import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento

/**
 * Define o contrato para regras de negócio específicas relacionadas ao [com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento],
 * permitindo variações de lógica conforme o perfil da clínica ou especialidade.
 */
interface ProcedimentoPolicy {

    fun tiposPermitidos(): Set<TipoProcedimento>
}