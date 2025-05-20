package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class BuscarConsultasPorProfissional(private val consultaRepository: ConsultaRepository) {

    fun execute(profissionalId: Long): List<Consulta> {
        return consultaRepository.buscarConsultasPorProfissional(profissionalId)
    }
}