package com.pluranex.api_consulta_saas.domain.paciente.usercases

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class AtualizarPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(pacienteId: Long, nome: String, telefone: String, email: String?): Paciente? {
        val paciente = Paciente(id = pacienteId, nome = nome, telefone = telefone, email = email)
        return pacienteRepository.atualizarPaciente(pacienteId, paciente)
    }
}