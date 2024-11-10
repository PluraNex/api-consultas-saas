package com.pluranex.api_consulta_saas.domain.profissional.usercases

import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import org.springframework.stereotype.Component

@Component
class ExcluirProfissional(private val profissionalRepository: ProfissionalRepository) {
    fun execute(profissionalId: Long): Boolean {
        return profissionalRepository.excluirProfissional(profissionalId)
    }
}