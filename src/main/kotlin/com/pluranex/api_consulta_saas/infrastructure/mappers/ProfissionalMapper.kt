package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.entities.Profissional
import com.pluranex.api_consulta_saas.infrastructure.models.ProfissionalModel

object ProfissionalMapper {

    fun toDomain(profissionalModel: ProfissionalModel): Profissional {
        return Profissional(
            id = profissionalModel.id,
            nome = profissionalModel.nome,
            especialidade = profissionalModel.especialidade,
            telefone = profissionalModel.telefone,
            email = profissionalModel.email
        )
    }

    fun toModel(profissional: Profissional): ProfissionalModel {
        return ProfissionalModel(
            id = profissional.id,
            nome = profissional.nome,
            especialidade = profissional.especialidade,
            telefone = profissional.telefone,
            email = profissional.email
        )
    }
}