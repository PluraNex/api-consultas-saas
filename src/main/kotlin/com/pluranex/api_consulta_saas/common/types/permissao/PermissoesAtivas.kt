package com.pluranex.api_consulta_saas.common.types.permissao

import com.pluranex.api_consulta_saas.common.session.enums.Permissao

@JvmInline
value class PermissoesAtivas(val value: Set<Permissao>) {
    fun contem(permissao: Permissao): Boolean = value.contains(permissao)

    fun contemTodas(vararg permissoes: Permissao): Boolean =
        permissoes.all { it in value }

    fun contemAlguma(vararg permissoes: Permissao): Boolean =
        permissoes.any { it in value }

    fun isVazio(): Boolean = value.isEmpty()
}
