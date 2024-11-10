package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.infrastructure.models.ConsultaModel

object ConsultaMapper {

    fun toModel(consulta: Consulta): ConsultaModel {
        return ConsultaModel(
            id = consulta.id,
            paciente = PacienteMapper.toModel(consulta.paciente),
            profissional = ProfissionalMapper.toModel(consulta.profissional),
            dataHorario = consulta.dataHorario,
            status = ConsultaModel.Status.valueOf(consulta.status.name),
            observacoes = consulta.observacoes
        )
    }

    fun toDomain(consultaModel: ConsultaModel): Consulta {
        return Consulta(
            id = consultaModel.id,
            paciente = PacienteMapper.toDomain(consultaModel.paciente),
            profissional = ProfissionalMapper.toDomain(consultaModel.profissional),
            dataHorario = consultaModel.dataHorario,
            status = StatusConsulta.valueOf(consultaModel.status.name),
            observacoes = consultaModel.observacoes
        )
    }
}