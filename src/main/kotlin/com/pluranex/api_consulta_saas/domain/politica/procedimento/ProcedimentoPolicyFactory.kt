package com.pluranex.api_consulta_saas.domain.politica.procedimento

import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import org.springframework.stereotype.Component

/**
 * Resolve dinamicamente a [ProcedimentoPolicy] com base no perfil da clínica.
 */
@Component
class ProcedimentoPolicyFactory(
    private val politicas: List<ProcedimentoPolicy>
) {
    fun resolver(perfil: PerfilClinica): ProcedimentoPolicy {
        val politica = politicas.find {
            val annotation = it::class.java.getAnnotation(Policy::class.java)
            annotation?.type == TipoPolitica.PROCEDIMENTO &&
                    annotation.name == when (perfil) {
                PerfilClinica.DESENVOLVIMENTO_INFANTIL -> NomePolitica.INFANTIL
                else -> NomePolitica.DEFAULT
            }
        }

        return politica ?: politicas.find {
            it::class.java.getAnnotation(Policy::class.java)?.name == NomePolitica.DEFAULT
        } ?: throw IllegalStateException("Nenhuma política de procedimento encontrada.")
    }
}
