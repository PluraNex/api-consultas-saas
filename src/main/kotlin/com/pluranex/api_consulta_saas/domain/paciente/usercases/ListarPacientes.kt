package com.pluranex.api_consulta_saas.domain.paciente.usercases

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.paciente.PacienteRepository
import org.springframework.stereotype.Component

@Component
class ListarPacientes(private val pacienteRepository: PacienteRepository) {
    fun execute(): List<Paciente> = pacienteRepository.listarPacientes()
}