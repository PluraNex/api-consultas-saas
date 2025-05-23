package com.pluranex.api_consulta_saas.common.session.core

/**
 * Representa um recurso do sistema que possui limite e consumo controlado.
 *
 * @property limite Valor total disponível no plano contratado
 * @property utilizado Valor já consumido
 */
data class RecursoLimite(
    val limite: Int,
    val utilizado: Int
) {
    val restante: Int
        get() = (limite - utilizado).coerceAtLeast(0)

    val percentualUso: Double
        get() = if (limite == 0) 0.0 else (utilizado.toDouble() / limite) * 100
}
