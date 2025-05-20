package com.pluranex.api_consulta_saas.domain.paciente.usecase

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class CriarPaciente(private val pacienteRepository: PacienteRepository) {
    fun execute(nome: String, telefone: String, email: String?): Paciente {
        val paciente = Paciente(nome = nome, telefone = telefone, email = email)
        return pacienteRepository.criarPaciente(paciente)
    }
}