package com.pluranex.api_consulta_saas.domain.profissional

interface ProfissionalRepository {
    fun listarProfissionais(): List<Profissional>
    fun buscarProfissionalPorId(id: Long): Profissional?
    fun criarProfissional(profissional: Profissional): Profissional
    fun atualizarProfissional(profissionalId: Long, profissional: Profissional): Profissional?
    fun excluirProfissional(profissionalId: Long): Boolean
}