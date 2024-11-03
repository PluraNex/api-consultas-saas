package com.pluranex.api_consulta_saas.domain.usecases.paciente

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.repositories.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class ListarPacientes(private val pacienteRepository: PacienteRepository) {
    fun execute(): List<Paciente> = pacienteRepository.listarPacientes()
}