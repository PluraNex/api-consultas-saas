package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.models.PacienteModel

object PacienteMapper {

    fun toDomain(pacienteModel: PacienteModel): Paciente {
        return Paciente(
            id = pacienteModel.id,
            nome = pacienteModel.nome,
            telefone = pacienteModel.telefone,
            email = pacienteModel.email
        )
    }

    fun toModel(paciente: Paciente): PacienteModel {
        return PacienteModel(
            id = paciente.id,
            nome = paciente.nome,
            telefone = paciente.telefone,
            email = paciente.email
        )
    }
}