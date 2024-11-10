package com.pluranex.api_consulta_saas.adapters.dtos.consulta

import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import java.time.LocalDateTime

data class ConsultaRequestDto(
    val pacienteId: Long,
    val profissionalId: Long,
    val dataHorario: LocalDateTime
) {

    fun toDomain(paciente: Paciente, profissional: Profissional): Consulta {
        return Consulta(
            paciente = paciente,
            profissional = profissional,
            dataHorario = dataHorario,
            status = StatusConsulta.PENDENTE
        )
    }
}
