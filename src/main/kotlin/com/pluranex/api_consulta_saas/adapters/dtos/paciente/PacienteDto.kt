package com.pluranex.api_consulta_saas.adapters.dtos.paciente

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
data class PacienteDto(
    val id: Long?,
    val nome: String,
    val telefone: String,
    val email: String?
) {
    companion object {
        fun fromDomain(paciente: Paciente) = PacienteDto(
            id = paciente.id,
            nome = paciente.nome,
            telefone = paciente.telefone,
            email = paciente.email
        )
    }
}