package com.pluranex.api_consulta_saas.domain.sessao

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario

/**
 * Serviço de domínio que fornece acesso ao usuário autenticado atual
 * e seu contexto de sessão.
 *
 * Esta interface é implementada na camada de aplicação/infraestrutura,
 * sendo usada por casos de uso e regras de negócio.
 */
interface SessaoService {

    /**
     * Retorna o usuário autenticado atual (identidade e perfil).
     */
    fun obterUsuarioAutenticado(): UsuarioAutenticado

    /**
     * Retorna o contexto completo da sessão, incluindo permissões, parâmetros e plano.
     */
    fun obterContextoSessao(): SessaoContextoDomain

    /**
     * Retorna uma representação completa da sessão atual.
     */
    fun obterSessaoUsuario(): SessaoUsuario
}
