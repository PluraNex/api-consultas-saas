package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ListarConsultasAtrasadas(private val consultaRepository: ConsultaRepository) {

    fun execute(): List<Consulta> {
        val agora = LocalDateTime.now()
        return consultaRepository.listarConsultas().filter { consulta ->
            consulta.dataHorario.isBefore(agora) &&
                    (consulta.status == StatusConsulta.PENDENTE || consulta.status == StatusConsulta.CONFIRMADA)
        }
    }
}