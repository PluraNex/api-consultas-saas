package com.pluranex.api_consulta_saas.domain.recurso.types

/**
 * Value Object que representa um recurso limitado por quantidade contratada e usada.
 *
 * Utilizado em contextos como SMS, e-mails, armazenamento, tokens de IA, etc.
 * Permite validar esgotamento, disponibilidade e consumo seguro.
 *
 * ### Exemplo:
 * ```kotlin
 * val limite = RecursoLimite(1000, 200)
 * println(limite.restante()) // 800
 * println(limite.porcentagemUso()) // 20
 * ```
 *
 * @property contratado Quantidade total contratada do recurso.
 * @property usado Quantidade já utilizada.
 */
data class RecursoLimite(
    val contratado: Int,
    val usado: Int
) {

    fun restante(): Int = contratado - usado

    fun estaEsgotado(): Boolean = restante() <= 0

    fun excedeuLimite(): Boolean = usado > contratado

    fun porcentagemUso(): Int =
        if (contratado == 0) 100 else ((usado * 100.0) / contratado).toInt().coerceIn(0, 100)

    fun usar(qtd: Int): RecursoLimite =
        copy(usado = (usado + qtd).coerceAtMost(contratado))

    fun resetarUso(): RecursoLimite = copy(usado = 0)

    fun estahDisponivel(qtd: Int): Boolean = restante() >= qtd

    fun descricao(): String = "$usado de $contratado usados (${porcentagemUso()}%)"
}
