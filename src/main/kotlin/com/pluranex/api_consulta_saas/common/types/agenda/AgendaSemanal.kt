package com.pluranex.api_consulta_saas.common.types.agenda

import com.pluranex.api_consulta_saas.common.types.tempo.DiaSemana
import com.pluranex.api_consulta_saas.common.types.tempo.IntervaloHorario
import java.io.Serializable

/**
 * Representa a agenda semanal base de um recurso (profissional, sala, etc.),
 * indicando os intervalos disponíveis para cada dia da semana.
 *
 * Exemplo:
 * ```
 * AgendaSemanal(
 *   mapOf(
 *     DiaSemana.SEGUNDA to listOf(IntervaloHorario("08:00", "12:00"))
 *   )
 * )
 * ```
 */
data class AgendaSemanal(
    val disponibilidadePorDia: Map<DiaSemana, List<IntervaloHorario>> = emptyMap()
) : Serializable {

    fun estaDisponivel(dia: DiaSemana): Boolean =
        disponibilidadePorDia[dia]?.isNotEmpty() == true

    fun horariosNoDia(dia: DiaSemana): List<IntervaloHorario> =
        disponibilidadePorDia[dia] ?: emptyList()

    fun diasComDisponibilidade(): Set<DiaSemana> =
        disponibilidadePorDia.filterValues { it.isNotEmpty() }.keys
}
