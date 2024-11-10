package com.pluranex.api_consulta_saas.domain.consulta.usercases

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class ConfirmarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(consultaId: Long): Consulta {
        val consulta = consultaRepository.buscarConsultaPorId(consultaId)
            ?: throw Exception("Consulta não encontrada")

        consulta.status = StatusConsulta.CONFIRMADA
        return consultaRepository.atualizarConsulta(consulta)
    }
}