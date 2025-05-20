package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class CancelarConsulta(private val consultaRepository: ConsultaRepository) {
    fun execute(consultaId: Long) {
        consultaRepository.cancelarConsulta(consultaId)
    }
}