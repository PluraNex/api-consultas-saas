package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude
import com.pluranex.api_consulta_saas.infrastructure.models.EmpresaSaudeModel

object EmpresaSaudeMapper {

    fun toDomain(model: EmpresaSaudeModel): EmpresaSaude =
        EmpresaSaude(id = model.id, nome = model.nome)

    fun toModel(entity: EmpresaSaude): EmpresaSaudeModel =
        EmpresaSaudeModel(id = entity.id, nome = entity.nome)
}
