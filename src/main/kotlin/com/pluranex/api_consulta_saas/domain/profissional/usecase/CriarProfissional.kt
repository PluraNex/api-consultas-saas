package com.pluranex.api_consulta_saas.domain.profissional.usecase

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class CriarProfissional(private val profissionalRepository: ProfissionalRepository) {
    fun execute(nome: String, especialidade: String, telefone: String, email: String?): Profissional {
        val profissional = Profissional(nome = nome, especialidade = especialidade, telefone = telefone, email = email)
        return profissionalRepository.criarProfissional(profissional)
    }
}