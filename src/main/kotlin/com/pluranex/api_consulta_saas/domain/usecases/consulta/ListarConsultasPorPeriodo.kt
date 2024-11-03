package com.pluranex.api_consulta_saas.domain.usecases.consulta

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.infrastructure.repositories.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ListarConsultasPorPeriodo(private val consultaRepository: ConsultaRepository) {

    fun execute(start: LocalDateTime, end: LocalDateTime): List<Consulta> {
        return consultaRepository.listarConsultasPorPeriodo(start, end)
    }
}