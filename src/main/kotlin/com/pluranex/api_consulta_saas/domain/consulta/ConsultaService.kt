package com.pluranex.api_consulta_saas.domain.consulta

import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaUpdateDto
import java.time.LocalDateTime

interface ConsultaService {
    fun listarTodasConsultas(): List<Consulta>
    fun criarNovaConsulta(consultaRequestDto: ConsultaRequestDto): Consulta
    fun atualizarConsulta(id: Long, consultaUpdateDto: ConsultaUpdateDto): Consulta
    fun confirmarConsulta(consultaId: Long): Consulta
    fun cancelarConsulta(consultaId: Long)
    fun finalizarConsulta(consultaId: Long): Consulta
    fun listarConsultasNoPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta>
    fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta>
    fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta>
    fun reagendarConsulta(dataAntiga: LocalDateTime, novaDataHorario: LocalDateTime): List<Consulta>
}
