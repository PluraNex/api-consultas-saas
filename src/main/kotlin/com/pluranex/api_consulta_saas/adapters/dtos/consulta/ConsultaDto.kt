package com.pluranex.api_consulta_saas.adapters.dtos.consulta

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import java.time.LocalDateTime

data class ConsultaDto(
    val id: Long? = null,
    val pacienteId: Long,
    val profissionalId: Long,
    val dataHorario: LocalDateTime,
    val status: String = StatusConsulta.PENDENTE.name,
    val criadoEm: LocalDateTime? = null,
    val atualizadoEm: LocalDateTime? = null
) {
    companion object {
        fun fromDomain(consulta: Consulta) = ConsultaDto(
            id = consulta.id,
            pacienteId = consulta.paciente.id!!,
            profissionalId = consulta.profissional.id!!,
            dataHorario = consulta.dataHorario,
            status = consulta.status.name
        )
    }

    fun toDomain(paciente: Paciente, profissional: Profissional): Consulta {
        return Consulta(
            id = id,
            paciente = paciente,
            profissional = profissional,
            dataHorario = dataHorario,
            status = enumValueOf(status.uppercase())
        )
    }
}
