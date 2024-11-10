package com.pluranex.api_consulta_saas.domain.paciente.usercases

import com.pluranex.api_consulta_saas.domain.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class ExcluirPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(pacienteId: Long): Boolean {
        return pacienteRepository.excluirPaciente(pacienteId)
    }
}