package com.pluranex.api_consulta_saas.domain.usecases.paciente

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.repositories.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class BuscarPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(pacienteId: Long): Paciente? {
        return pacienteRepository.buscarPacientePorId(pacienteId)
    }
}