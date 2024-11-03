package com.pluranex.api_consulta_saas.domain.usecases.consulta

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.domain.enums.StatusConsulta
import com.pluranex.api_consulta_saas.infrastructure.repositories.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class FinalizarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(consultaId: Long): Consulta {
        val consulta = consultaRepository.buscarConsultaPorId(consultaId)
            ?: throw Exception("Consulta não encontrada")

        consulta.status = StatusConsulta.FINALIZADA
        return consultaRepository.atualizarConsulta(consulta)
    }
}