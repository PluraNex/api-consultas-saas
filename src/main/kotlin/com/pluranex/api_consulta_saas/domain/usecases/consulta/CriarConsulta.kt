package com.pluranex.api_consulta_saas.domain.usecases.consulta

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.infrastructure.repositories.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class CriarConsulta(private val consultaRepository: ConsultaRepository) {
    fun execute(consulta: Consulta): Consulta = consultaRepository.criarConsulta(consulta)
}