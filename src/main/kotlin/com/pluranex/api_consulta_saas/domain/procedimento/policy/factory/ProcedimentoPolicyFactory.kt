package com.pluranex.api_consulta_saas.domain.procedimento.policy.factory

import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import com.pluranex.api_consulta_saas.domain.procedimento.policy.definition.ProcedimentoPolicy
import org.springframework.stereotype.Component

/**
 * Resolve dinamicamente a [com.pluranex.api_consulta_saas.domain.procedimento.policy.definition.ProcedimentoPolicy] com base no perfil da clínica.
 */
@Component
class ProcedimentoPolicyFactory(
    private val politicas: List<ProcedimentoPolicy>
) {
    fun resolver(perfil: PerfilClinica): ProcedimentoPolicy {
        val nomePolitica = mapearNomePolitica(perfil)

        val politicaPorPerfil = politicas.find {
            val annotation = it::class.java.getAnnotation(Policy::class.java)
            annotation?.type == TipoPolitica.PROCEDIMENTO &&
                    annotation.name == nomePolitica
        }

        return politicaPorPerfil ?: politicas.find {
            it::class.java.getAnnotation(Policy::class.java)?.name == NomePolitica.DEFAULT
        } ?: throw IllegalStateException("Nenhuma política de procedimento encontrada.")
    }

    /**
     * Mapeia o [PerfilClinica] para um [NomePolitica] correspondente.
     * Pode ser facilmente expandido para novos perfis no futuro.
     */
    private fun mapearNomePolitica(perfil: PerfilClinica): NomePolitica {
        return when (perfil) {
            PerfilClinica.DESENVOLVIMENTO_INFANTIL -> NomePolitica.INFANTIL
            PerfilClinica.MULTIDISCIPLINAR         -> NomePolitica.MULTIDISCIPLINAR
            PerfilClinica.PEDIATRIA                -> NomePolitica.PEDIATRIA
            else                                   -> NomePolitica.DEFAULT
        }
    }
}
