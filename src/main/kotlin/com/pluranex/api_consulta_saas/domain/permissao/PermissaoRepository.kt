package com.pluranex.api_consulta_saas.domain.permissao

import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao

interface PermissaoRepository {
    fun salvar(permissao: PermissaoUsuario): PermissaoUsuario
    fun salvarTodas(permissoes: List<PermissaoUsuario>): List<PermissaoUsuario>
    fun listarPorUsuarioId(usuarioId: Long): List<PermissaoUsuario>
    fun deletarPorUsuarioId(usuarioId: Long)
    fun existePermissao(usuarioId: Long, permissao: Permissao): Boolean
}