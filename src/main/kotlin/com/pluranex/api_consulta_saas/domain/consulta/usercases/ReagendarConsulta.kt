package com.pluranex.api_consulta_saas.domain.consulta.usercases

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ReagendarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(dataAntiga: LocalDateTime, novaDataHorario: LocalDateTime): List<Consulta> {
        val consultas = consultaRepository.listarConsultasPorPeriodo(dataAntiga, dataAntiga.plusDays(1))

        return consultas.map { consulta ->
            consulta.dataHorario = novaDataHorario
            consultaRepository.atualizarConsulta(consulta)
        }
    }
}