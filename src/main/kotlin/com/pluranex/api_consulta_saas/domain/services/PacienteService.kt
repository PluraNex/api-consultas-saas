package com.pluranex.api_consulta_saas.domain.services

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.domain.usecases.paciente.*
import org.springframework.stereotype.Service

@Service
class PacienteService(
    private val listarPacientes: ListarPacientes,
    private val buscarPaciente: BuscarPaciente,
    private val criarPaciente: CriarPaciente,
    private val atualizarPaciente: AtualizarPaciente,
    private val excluirPaciente: ExcluirPaciente
) {

    fun listarTodosPacientes(): List<Paciente> {
        return listarPacientes.execute()
    }

    fun buscarPacientePorId(id: Long): Paciente? {
        return buscarPaciente.execute(id)
    }

    fun criarNovoPaciente(nome: String, telefone: String, email: String?): Paciente {
        return criarPaciente.execute(nome, telefone, email)
    }

    fun atualizarPaciente(id: Long, nome: String, telefone: String, email: String?): Paciente? {
        return atualizarPaciente.execute(id, nome, telefone, email)
    }

    fun excluirPaciente(id: Long): Boolean {
        return excluirPaciente.execute(id)
    }
}
