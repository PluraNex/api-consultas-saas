package com.pluranex.api_consulta_saas.domain.procedimento.policy.service

import com.pluranex.api_consulta_saas.common.annotations.Provider
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessaoResolver
import com.pluranex.api_consulta_saas.domain.procedimento.policy.definition.ProcedimentoPolicy
import com.pluranex.api_consulta_saas.domain.procedimento.policy.factory.ProcedimentoPolicyFactory

/**
 * Provider que encapsula a lógica de resolução da política ativa de procedimento
 * com base no perfil da clínica atual da sessão.
 *
 * Permite reutilizar essa lógica de forma padronizada e evitar duplicações
 * em validators e regras.
 */
@Provider
class ProcedimentoPolicyProvider(
    private val procedimentoPolicyFactory: ProcedimentoPolicyFactory,
    private val contextoSessaoResolver: ContextoSessaoResolver
) {

    /**
     * Retorna a política ativa de procedimentos para a clínica da sessão atual.
     */
    fun get(): ProcedimentoPolicy {
        val perfilClinica = contextoSessaoResolver.obterPerfilClinica()
        return procedimentoPolicyFactory.resolver(perfilClinica)
    }
}
