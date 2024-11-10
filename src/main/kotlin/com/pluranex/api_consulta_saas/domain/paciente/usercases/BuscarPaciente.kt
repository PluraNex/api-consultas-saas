package com.pluranex.api_consulta_saas.domain.paciente.usercases

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class BuscarPaciente(
    private val  pacienteRepository: PacienteRepository
) {
    fun executar(id: Long): Paciente {
        return pacienteRepository.buscarPacientePorId(id)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.PACIENTE_NOT_FOUND,
                "Paciente com ID $id não encontrado."
            )
    }
}