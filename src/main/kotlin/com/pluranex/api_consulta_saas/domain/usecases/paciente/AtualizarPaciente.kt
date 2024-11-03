package com.pluranex.api_consulta_saas.domain.usecases.paciente

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.repositories.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class AtualizarPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(pacienteId: Long, nome: String, telefone: String, email: String?): Paciente? {
        val paciente = Paciente(id = pacienteId, nome = nome, telefone = telefone, email = email)
        return pacienteRepository.atualizarPaciente(pacienteId, paciente)
    }
}