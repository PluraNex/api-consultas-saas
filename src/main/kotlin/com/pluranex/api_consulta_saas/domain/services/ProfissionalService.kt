package com.pluranex.api_consulta_saas.domain.services

import com.pluranex.api_consulta_saas.domain.entities.Profissional
import com.pluranex.api_consulta_saas.domain.usecases.profissional.*
import org.springframework.stereotype.Service

@Service
class ProfissionalService(
    private val listarProfissionais: ListarProfissionais,
    private val buscarProfissional: BuscarProfissional,
    private val criarProfissional: CriarProfissional,
    private val atualizarProfissional: AtualizarProfissional,
    private val excluirProfissional: ExcluirProfissional
) {

    fun listarTodosProfissionais(): List<Profissional> {
        return listarProfissionais.execute()
    }

    fun buscarProfissionalPorId(id: Long): Profissional? {
        return buscarProfissional.execute(id)
    }

    fun criarNovoProfissional(nome: String, especialidade: String, telefone: String, email: String?): Profissional {
        return criarProfissional.execute(nome, especialidade, telefone, email)
    }

    fun atualizarProfissional(id: Long, nome: String, especialidade: String, telefone: String, email: String?): Profissional? {
        return atualizarProfissional.execute(id, nome, especialidade, telefone, email)
    }

    fun excluirProfissional(id: Long): Boolean {
        return excluirProfissional.execute(id)
    }
}