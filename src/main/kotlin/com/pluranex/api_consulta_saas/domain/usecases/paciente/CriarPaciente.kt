package com.pluranex.api_consulta_saas.domain.usecases.paciente

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.repositories.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class CriarPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(nome: String, telefone: String, email: String?): Paciente {
        val paciente = Paciente(nome = nome, telefone = telefone, email = email)
        return pacienteRepository.criarPaciente(paciente)
    }
}