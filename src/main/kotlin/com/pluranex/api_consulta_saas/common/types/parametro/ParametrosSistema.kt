package com.pluranex.api_consulta_saas.common.types.parametro

import com.pluranex.api_consulta_saas.common.session.enums.ParametroSistema

@JvmInline
value class ParametrosSistema(val value: Map<ParametroSistema, String>)
