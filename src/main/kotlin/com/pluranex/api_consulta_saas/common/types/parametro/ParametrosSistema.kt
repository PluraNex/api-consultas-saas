package com.pluranex.api_consulta_saas.common.types.parametro

import com.pluranex.api_consulta_saas.common.session.enums.ParametroSistema

/**
 * Value class que representa o conjunto de parâmetros configuráveis do sistema.
 *
 * Permite acesso seguro e tipado a valores configurados por clínica, perfil ou ambiente.
 */
@JvmInline
value class ParametrosSistema(val value: Map<ParametroSistema, String>) {

    /**
     * Retorna o valor do parâmetro como [Boolean], ou [default] se ausente ou inválido.
     */
    fun getBoolean(param: ParametroSistema, default: Boolean = false): Boolean =
        value[param]?.toBooleanStrictOrNull() ?: default

    /**
     * Retorna o valor do parâmetro como [Int], ou [default] se ausente ou inválido.
     */
    fun getInt(param: ParametroSistema, default: Int = 0): Int =
        value[param]?.toIntOrNull() ?: default

    /**
     * Retorna o valor do parâmetro como [String], ou [default] se ausente.
     */
    fun getString(param: ParametroSistema, default: String = ""): String =
        value[param] ?: default
}
