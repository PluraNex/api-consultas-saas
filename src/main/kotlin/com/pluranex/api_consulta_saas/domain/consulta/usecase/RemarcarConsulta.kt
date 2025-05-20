package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class RemarcarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(consultaId: Long, novaDataHorario: LocalDateTime): Consulta {
        val consulta = consultaRepository.buscarConsultaPorId(consultaId)
            ?: throw Exception("Consulta não encontrada")

        if (consulta.status == StatusConsulta.CANCELADA || consulta.status == StatusConsulta.FINALIZADA) {
            throw Exception("Não é possível remarcar uma consulta que já foi cancelada ou finalizada")
        }

        consulta.dataHorario = novaDataHorario
        return consultaRepository.atualizarConsulta(consulta)
    }
}