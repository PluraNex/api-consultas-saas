package com.pluranex.api_consulta_saas.common.types.agenda

import java.io.Serializable
import java.time.DayOfWeek
import java.time.LocalDate

/**
 * Representa uma regra de recorrência semanal associada a uma ou mais repetições
 * com base em dias fixos da semana, útil para controle de agendas e tarefas cíclicas.
 *
 * Esta estrutura é comumente usada para descrever padrões como:
 * - "Toda segunda e quarta-feira"
 * - "Repetir às terças"
 *
 * ### Responsabilidades:
 * - Registrar uma ou mais ocorrências semanais
 * - Definir a data de início da recorrência
 * - Informar número opcional de repetições (ou se é infinita)
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val regra = RegraRecorrencia(
 *     diasDaSemana = listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY),
 *     dataInicio = LocalDate.of(2025, 6, 1),
 *     repeticoes = 10
 * )
 * ```
 */
data class RegraRecorrencia(
    /** Dias da semana em que a recorrência deve acontecer (ex: segunda, quarta). */
    val diasDaSemana: List<DayOfWeek>,

    /** Data inicial a partir da qual a regra começa a valer. */
    val dataInicio: LocalDate,

    /** Número de repetições ou `null` se a recorrência for infinita. */
    val repeticoes: Int? = null
) : Serializable {

    init {
        require(diasDaSemana.isNotEmpty()) { "A regra de recorrência deve conter pelo menos um dia da semana." }
        require(repeticoes == null || repeticoes > 0) { "O número de repetições deve ser nulo (infinito) ou maior que zero." }
    }

    /**
     * Verifica se a data fornecida corresponde a um dos dias de recorrência.
     */
    fun ocorreEm(data: LocalDate): Boolean {
        return !data.isBefore(dataInicio) && diasDaSemana.contains(data.dayOfWeek)
    }
}
