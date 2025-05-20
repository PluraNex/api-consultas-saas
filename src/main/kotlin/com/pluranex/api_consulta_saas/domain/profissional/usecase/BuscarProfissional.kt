package com.pluranex.api_consulta_saas.domain.profissional.usecase

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class BuscarProfissional(private val profissionalRepository: ProfissionalRepository) {
    fun execute(profissionalId: Long): Profissional? {
        return profissionalRepository.buscarProfissionalPorId(profissionalId)
    }
}