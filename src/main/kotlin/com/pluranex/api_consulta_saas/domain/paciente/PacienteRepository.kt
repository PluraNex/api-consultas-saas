package com.pluranex.api_consulta_saas.domain.paciente

interface PacienteRepository {
    fun listarPacientes(): List<Paciente>
    fun buscarPacientePorId(id: Long): Paciente?
    fun criarPaciente(paciente: Paciente): Paciente
    fun atualizarPaciente(pacienteId: Long, paciente: Paciente): Paciente?
    fun excluirPaciente(pacienteId: Long): Boolean
}