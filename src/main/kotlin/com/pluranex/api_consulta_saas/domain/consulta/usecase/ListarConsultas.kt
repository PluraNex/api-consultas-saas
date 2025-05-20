package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class ListarConsultas(private val consultaRepository: ConsultaRepository) {
    fun execute(): List<Consulta> = consultaRepository.listarConsultas()
}