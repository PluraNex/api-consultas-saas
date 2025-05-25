package com.pluranex.api_consulta_saas.domain.permissao

import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao

interface PermissaoService {
    fun atribuirPermissao(usuarioId: Long, permissao: PermissaoUsuario)
    fun atribuirMultiplasPermissoes(usuarioId: Long, permissoes: List<Permissao>): List<PermissaoUsuario>
    fun revogarPermissao(usuarioId: Long, permissao: PermissaoUsuario)
    fun listarPermissoesPorUsuario(usuarioId: Long): List<PermissaoUsuario>
    fun possuiPermissao(usuarioId: Long, permissao: Permissao): Boolean
}
