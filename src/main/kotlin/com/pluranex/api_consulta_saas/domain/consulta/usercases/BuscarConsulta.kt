package com.pluranex.api_consulta_saas.domain.consulta.usercases

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component

@Component
class BuscarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(id: Long): Consulta {
        return consultaRepository.buscarConsultaPorId(id)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.CONSULTA_NOT_FOUND,
                "Consulta com ID $id não encontrada."
            )
    }
}