package com.pluranex.api_consulta_saas.domain.entities

import com.pluranex.api_consulta_saas.domain.enums.StatusConsulta
import java.time.LocalDateTime

data class Consulta(
    val id: Long? = null,
    val paciente: Paciente,
    val profissional: Profissional,
    var dataHorario: LocalDateTime,
    var status: StatusConsulta = StatusConsulta.PENDENTE,
    val criadoEm: LocalDateTime = LocalDateTime.now(),
    val atualizadoEm: LocalDateTime = LocalDateTime.now()
)
