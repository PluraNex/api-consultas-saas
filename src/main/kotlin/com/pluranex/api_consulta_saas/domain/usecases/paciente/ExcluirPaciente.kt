package com.pluranex.api_consulta_saas.domain.usecases.paciente

import com.pluranex.api_consulta_saas.infrastructure.repositories.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class ExcluirPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(pacienteId: Long): Boolean {
        return pacienteRepository.excluirPaciente(pacienteId)
    }
}