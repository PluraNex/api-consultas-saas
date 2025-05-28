package com.pluranex.api_consulta_saas.domain.procedimento.validation.policy

import com.pluranex.api_consulta_saas.common.annotations.Validator
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessaoResolver
import com.pluranex.api_consulta_saas.domain.politica.procedimento.ProcedimentoPolicyFactory
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento

@Validator
class ProcedimentoPolicyValidator(
    private val procedimentoPolicyFactory: ProcedimentoPolicyFactory,
    private val contextoSessaoResolver: ContextoSessaoResolver
) {
    fun validar(procedimento: Procedimento) {
        val perfil = contextoSessaoResolver.obterPerfil()
        val politica = procedimentoPolicyFactory.resolver(perfil)

        if (!politica.permite(procedimento)) {
            throw IllegalArgumentException("O tipo de procedimento '${procedimento.tipo}' não é permitido para o perfil de clínica '$perfil'.")
        }
    }
}