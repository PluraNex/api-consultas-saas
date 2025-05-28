package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import org.springframework.stereotype.Component

/**
 * Resolve dados de contexto específicos relacionados à clínica da sessão.
 */
@Component
class ContextoSessaoResolver(
    private val contextoSessao: ContextoSessaoProvider
) {

    fun obterPerfil(): PerfilClinica {
        return contextoSessao.perfilClinica
    }

    fun isDesenvolvimentoInfantil(): Boolean {
        return contextoSessao.perfilClinica == PerfilClinica.DESENVOLVIMENTO_INFANTIL
    }
}
