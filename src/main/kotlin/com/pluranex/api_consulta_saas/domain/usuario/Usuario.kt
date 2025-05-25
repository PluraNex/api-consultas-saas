package com.pluranex.api_consulta_saas.domain.usuario

import com.pluranex.api_consulta_saas.common.session.core.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.contato.MeiosContato
import com.pluranex.api_consulta_saas.domain.permissao.PermissaoUsuario
import java.time.LocalDateTime

data class Usuario(
    val id: Long? = null,
    val nome: String,
    val contato: MeiosContato,
    val senhaHash: String,
    val perfil: PerfilUsuario,
    val permissoes: List<PermissaoUsuario> = emptyList(),
    val ativo: Boolean = true,
    val criadoPor: String? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now()
)