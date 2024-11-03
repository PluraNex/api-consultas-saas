package com.pluranex.api_consulta_saas.adapters.dtos

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import java.time.LocalDateTime

data class ConsultaDto(
    val id: Long?,
    val pacienteId: Long,
    val profissionalId: Long,
    val dataHorario: LocalDateTime,
    val status: String,
    val criadoEm: LocalDateTime,
    val atualizadoEm: LocalDateTime
) {
    companion object {
        fun fromDomain(consulta: Consulta) = ConsultaDto(
            id = consulta.id,
            pacienteId = consulta.paciente.id!!,
            profissionalId = consulta.profissional.id!!,
            dataHorario = consulta.dataHorario,
            status = consulta.status.name,
            criadoEm = consulta.criadoEm,
            atualizadoEm = consulta.atualizadoEm
        )

    }
}
