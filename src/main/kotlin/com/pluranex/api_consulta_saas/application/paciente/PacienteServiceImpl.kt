package com.pluranex.api_consulta_saas.application.paciente

import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.paciente.PacienteService
import com.pluranex.api_consulta_saas.domain.paciente.usercases.*
import org.springframework.stereotype.Service

@Service
class PacienteServiceImpl(
    private val listarPacientes: ListarPacientes,
    private val buscarPaciente: BuscarPaciente,
    private val criarPaciente: CriarPaciente,
    private val atualizarPaciente: AtualizarPaciente,
    private val excluirPaciente: ExcluirPaciente
) : PacienteService {

    override fun listarTodosPacientes(): List<Paciente> {
        return listarPacientes.execute()
    }

    override fun buscarPacientePorId(id: Long): Paciente {
        return buscarPaciente.executar(id)
    }

    override fun criarNovoPaciente(nome: String, telefone: String, email: String?): Paciente {
        return criarPaciente.execute(nome, telefone, email)
    }

    override fun atualizarPaciente(id: Long, nome: String, telefone: String, email: String?): Paciente {
        return atualizarPaciente.execute(id, nome, telefone, email)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.PACIENTE_NOT_FOUND,
                "Paciente com ID $id não encontrado para atualização."
            )
    }

    override fun excluirPaciente(id: Long): Boolean {
        return excluirPaciente.execute(id)
    }
}