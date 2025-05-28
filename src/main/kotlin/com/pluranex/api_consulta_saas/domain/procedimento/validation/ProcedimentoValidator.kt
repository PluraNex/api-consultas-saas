package com.pluranex.api_consulta_saas.domain.procedimento.validation

import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento


interface ProcedimentoValidator {
    fun validarCriacao(procedimento: Procedimento, clinica: Clinica)
    fun validarEdicao(procedimento: Procedimento)
    fun validarPermissaoPolitica(procedimento: Procedimento, clinica: Clinica)
    fun validarDadosObrigatorios(procedimento: Procedimento)
}

