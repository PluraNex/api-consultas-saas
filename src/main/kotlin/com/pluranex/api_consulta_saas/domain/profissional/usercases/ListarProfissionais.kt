package com.pluranex.api_consulta_saas.domain.profissional.usercases

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class ListarProfissionais(private val profissionalRepository: ProfissionalRepository) {
    fun execute(): List<Profissional> {
        return profissionalRepository.listarProfissionais()
    }
}