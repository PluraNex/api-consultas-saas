package com.pluranex.api_consulta_saas.domain.services
import com.pluranex.api_consulta_saas.domain.profissional.Profissional

interface ProfissionalService {
    fun listarTodosProfissionais(): List<Profissional>
    fun buscarProfissionalPorId(id: Long): Profissional
    fun criarNovoProfissional(nome: String, especialidade: String, telefone: String, email: String?): Profissional
    fun atualizarProfissional(id: Long, nome: String, especialidade: String, telefone: String, email: String?): Profissional
    fun excluirProfissional(id: Long): Boolean
}
