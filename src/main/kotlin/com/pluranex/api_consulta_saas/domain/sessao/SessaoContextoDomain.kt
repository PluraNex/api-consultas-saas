package com.pluranex.api_consulta_saas.domain.sessao

import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoTecnicoSessao

/**
 * Representa a sessão do ponto de vista do domínio, combinando:
 * - A identidade do usuário autenticado ([UsuarioAutenticado])
 * - O contexto técnico da sessão ([ContextoTecnicoSessao])
 *
 * Essa classe é usada para decisões de negócio, validações e controle de acesso.
 */
data class SessaoContextoDomain(
    val usuario: UsuarioAutenticado,
    val contexto: ContextoTecnicoSessao
)