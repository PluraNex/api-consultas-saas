package com.pluranex.api_consulta_saas.common.types.agenda

import com.pluranex.api_consulta_saas.common.types.tempo.DiaSemana
import com.pluranex.api_consulta_saas.common.types.tempo.IntervaloHorario
import java.io.Serializable

/**
 * Representa a disponibilidade semanal de um profissional de saúde para atendimentos regulares.
 *
 * Encapsula uma [AgendaSemanal], podendo evoluir futuramente para conter
 * exceções, bloqueios manuais ou eventos específicos.
 */
data class DisponibilidadeProfissional(
    val agendaSemanal: AgendaSemanal
) : Serializable {

    fun estaDisponivel(dia: DiaSemana): Boolean =
        agendaSemanal.estaDisponivel(dia)

    fun horariosDisponiveis(dia: DiaSemana): List<IntervaloHorario> =
        agendaSemanal.horariosNoDia(dia)

    fun diasDisponiveis(): Set<DiaSemana> =
        agendaSemanal.diasComDisponibilidade()
}
