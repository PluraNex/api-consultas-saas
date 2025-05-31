package com.pluranex.api_consulta_saas.domain.procedimento

import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento


interface ProcedimentoService {
    fun criarProcedimento(procedimento: Procedimento): Procedimento
    fun listarTiposProcedimento(): List<TipoProcedimento>
}

