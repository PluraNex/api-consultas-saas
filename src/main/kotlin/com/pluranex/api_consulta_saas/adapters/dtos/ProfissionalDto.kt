package com.pluranex.api_consulta_saas.adapters.dtos

import com.pluranex.api_consulta_saas.domain.profissional.Profissional

data class ProfissionalDto(
    val id: Long?,
    val nome: String,
    val especialidade: String,
    val telefone: String,
    val email: String?
) {
    companion object {
        fun fromDomain(profissional: Profissional): ProfissionalDto {
            return ProfissionalDto(
                id = profissional.id,
                nome = profissional.nome,
                especialidade = profissional.especialidade,
                telefone = profissional.telefone,
                email = profissional.email
            )
        }
    }

    fun toDomain(): Profissional {
        return Profissional(
            id = this.id,
            nome = this.nome,
            especialidade = this.especialidade,
            telefone = this.telefone,
            email = this.email
        )
    }
}