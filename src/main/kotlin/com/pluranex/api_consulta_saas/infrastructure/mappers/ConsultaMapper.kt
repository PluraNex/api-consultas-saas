package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.domain.enums.StatusConsulta
import com.pluranex.api_consulta_saas.infrastructure.models.ConsultaModel

object ConsultaMapper {

    // Converte de Consulta (domínio) para ConsultaModel (persistência)
    fun toModel(consulta: Consulta): ConsultaModel {
        return ConsultaModel(
            id = consulta.id,
            paciente = PacienteMapper.toModel(consulta.paciente),
            profissional = ProfissionalMapper.toModel(consulta.profissional),
            dataHorario = consulta.dataHorario,
            status = ConsultaModel.Status.valueOf(consulta.status.name),
            criadoEm = consulta.criadoEm,
            atualizadoEm = consulta.atualizadoEm
        )
    }

    // Converte de ConsultaModel (persistência) para Consulta (domínio)
    fun toDomain(consultaModel: ConsultaModel): Consulta {
        return Consulta(
            id = consultaModel.id,
            paciente = PacienteMapper.toDomain(consultaModel.paciente),
            profissional = ProfissionalMapper.toDomain(consultaModel.profissional),
            dataHorario = consultaModel.dataHorario,
            status = StatusConsulta.valueOf(consultaModel.status.name),
            criadoEm = consultaModel.criadoEm,
            atualizadoEm = consultaModel.atualizadoEm
        )
    }
}