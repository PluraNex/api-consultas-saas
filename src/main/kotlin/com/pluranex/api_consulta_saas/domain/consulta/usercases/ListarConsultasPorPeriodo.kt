package com.pluranex.api_consulta_saas.domain.consulta.usercases

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ListarConsultasPorPeriodo(private val consultaRepository: ConsultaRepository) {

    fun execute(start: LocalDateTime, end: LocalDateTime): List<Consulta> {
        return consultaRepository.listarConsultasPorPeriodo(start, end)
    }
}