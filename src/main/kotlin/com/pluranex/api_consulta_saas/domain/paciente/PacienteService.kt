package com.pluranex.api_consulta_saas.domain.paciente

interface PacienteService {
    fun listarTodosPacientes(): List<Paciente>
    fun buscarPacientePorId(id: Long): Paciente
    fun criarNovoPaciente(nome: String, telefone: String, email: String?): Paciente
    fun atualizarPaciente(id: Long, nome: String, telefone: String, email: String?): Paciente
    fun excluirPaciente(id: Long): Boolean
}
