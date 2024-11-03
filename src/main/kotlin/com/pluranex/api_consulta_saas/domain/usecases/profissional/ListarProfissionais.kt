package com.pluranex.api_consulta_saas.domain.usecases.profissional

import com.pluranex.api_consulta_saas.domain.entities.Profissional
import com.pluranex.api_consulta_saas.infrastructure.repositories.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class ListarProfissionais(private val profissionalRepository: ProfissionalRepository) {
    fun execute(): List<Profissional> {
        return profissionalRepository.listarProfissionais()
    }
}