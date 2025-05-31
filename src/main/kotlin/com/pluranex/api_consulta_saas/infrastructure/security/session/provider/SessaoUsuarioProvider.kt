package com.pluranex.api_consulta_saas.infrastructure.security.session.provider

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import jakarta.servlet.http.HttpServletRequest

/**
 * Contrato base para resolução da sessão do usuário a partir da requisição.
 * Pode ter múltiplas implementações, como:
 * - JwtSessaoUsuarioProviderImpl (produção)
 * - DevSessaoUsuarioProviderImpl (ambiente de desenvolvimento)
 */
interface SessaoUsuarioProvider {
    fun getSessao(request: HttpServletRequest): SessaoUsuario
}
