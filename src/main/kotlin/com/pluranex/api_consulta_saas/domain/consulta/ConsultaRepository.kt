package com.pluranex.api_consulta_saas.domain.consulta

import java.time.LocalDateTime

interface ConsultaRepository {
    fun buscarConsultaPorId(id: Long): Consulta?
    fun listarConsultas(): List<Consulta>
    fun criarConsulta(consulta: Consulta): Consulta
    fun atualizarConsulta(consulta: Consulta): Consulta
    fun listarConsultasPorPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta>
    fun cancelarConsulta(consultaId: Long): Consulta?
    fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta>
    fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta>
}
