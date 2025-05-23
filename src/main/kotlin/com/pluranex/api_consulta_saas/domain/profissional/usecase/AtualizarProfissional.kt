package com.pluranex.api_consulta_saas.domain.profissional.usecase

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class AtualizarProfissional(private val profissionalRepository: ProfissionalRepository) {
    fun execute(profissionalId: Long, nome: String, especialidade: String, telefone: String, email: String?): Profissional? {
        val profissional = Profissional(id = profissionalId, nome = nome, especialidade = especialidade, telefone = telefone, email = email)
        return profissionalRepository.atualizarProfissional(profissionalId, profissional)
    }
}