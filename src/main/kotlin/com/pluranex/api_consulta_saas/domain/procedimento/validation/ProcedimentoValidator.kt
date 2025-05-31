package com.pluranex.api_consulta_saas.domain.procedimento.validation

import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento


interface ProcedimentoValidator {
    fun validarCriacao(procedimento: Procedimento)
}

