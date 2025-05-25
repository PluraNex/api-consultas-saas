package com.pluranex.api_consulta_saas.domain.plano.validation

import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.enums.recurso.TipoRecurso

interface PlanoValidator {
    /**
     * Verifica se o plano atual está entre os permitidos.
     */
    fun validarPlanoAtual(plano: PlanoTenant, vararg permitidos: PlanoTenant)

    /**
     * Verifica se há disponibilidade de recurso do tipo especificado.
     */
    fun validarDisponibilidade(tipoRecurso: TipoRecurso, quantidade: Int = 1)
}
