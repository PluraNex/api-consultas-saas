package com.pluranex.api_consulta_saas.domain.consulta.usercases

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class BuscarConsultasPorPaciente(private val consultaRepository: ConsultaRepository) {

    fun execute(pacienteId: Long): List<Consulta> {
        return consultaRepository.buscarConsultasPorPaciente(pacienteId)
    }
}