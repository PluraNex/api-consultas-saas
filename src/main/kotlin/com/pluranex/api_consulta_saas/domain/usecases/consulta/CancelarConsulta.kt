package com.pluranex.api_consulta_saas.domain.usecases.consulta

import com.pluranex.api_consulta_saas.infrastructure.repositories.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class CancelarConsulta(private val consultaRepository: ConsultaRepository) {
    fun execute(consultaId: Long) {
        consultaRepository.cancelarConsulta(consultaId)
    }
}