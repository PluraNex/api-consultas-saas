package com.pluranex.api_consulta_saas.adapters.dtos.consulta

import java.time.LocalDateTime


data class ConsultaUpdateDto(
    val profissionalId: Long?,
    val dataHorario: LocalDateTime?,
    val observacoes: String?
)