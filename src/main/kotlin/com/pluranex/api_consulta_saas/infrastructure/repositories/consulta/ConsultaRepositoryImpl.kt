package com.pluranex.api_consulta_saas.infrastructure.repositories.consulta

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.ConsultaMapper
import com.pluranex.api_consulta_saas.infrastructure.models.ConsultaModel
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ConsultaRepositoryImpl(
    private val consultaJpaRepository: ConsultaJpaRepository
) : ConsultaRepository {

    override fun buscarConsultaPorId(id: Long): Consulta? {
        return consultaJpaRepository.findById(id).orElse(null)?.let { ConsultaMapper.toDomain(it) }
    }

    override fun listarConsultas(): List<Consulta> {
        return consultaJpaRepository.findAll().map { ConsultaMapper.toDomain(it) }
    }

    override fun criarConsulta(consulta: Consulta): Consulta {
        val model = ConsultaMapper.toModel(consulta)
        return ConsultaMapper.toDomain(consultaJpaRepository.save(model))
    }

    override fun atualizarConsulta(consulta: Consulta): Consulta {
        val model = ConsultaMapper.toModel(consulta)
        return ConsultaMapper.toDomain(consultaJpaRepository.save(model))
    }

    override fun listarConsultasPorPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta> {
        return consultaJpaRepository.findAllByDataHorarioBetween(start, end).map { ConsultaMapper.toDomain(it) }
    }

    override fun cancelarConsulta(consultaId: Long): Consulta? {
        val consultaModel = consultaJpaRepository.findById(consultaId).orElse(null)
            ?: return null

        consultaModel.status = ConsultaModel.Status.CANCELADA
        return ConsultaMapper.toDomain(consultaJpaRepository.save(consultaModel))
    }

    override fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta> {
        return consultaJpaRepository.findAllByPaciente_Id(pacienteId).map { ConsultaMapper.toDomain(it) }
    }

    override fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta> {
        return consultaJpaRepository.findAllByProfissional_Id(profissionalId).map { ConsultaMapper.toDomain(it) }
    }
}
