package com.pluranex.api_consulta_saas.common.types.permission

import com.pluranex.api_consulta_saas.common.session.enums.Permissao

@JvmInline
value class PermissoesAtivas(val value: Set<Permissao>)
