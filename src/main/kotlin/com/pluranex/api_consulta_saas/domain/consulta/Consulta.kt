package com.pluranex.api_consulta_saas.domain.consulta

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import java.time.LocalDateTime

data class Consulta(
    val id: Long? = null,
    val paciente: Paciente,
    var profissional: Profissional,
    var dataHorario: LocalDateTime,
    var status: StatusConsulta = StatusConsulta.PENDENTE,
    var observacoes: String? = null,
)
