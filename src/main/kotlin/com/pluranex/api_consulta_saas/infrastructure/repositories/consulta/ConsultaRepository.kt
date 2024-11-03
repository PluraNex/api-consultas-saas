package com.pluranex.api_consulta_saas.infrastructure.repositories.consulta

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.infrastructure.mappers.ConsultaMapper
import com.pluranex.api_consulta_saas.infrastructure.models.ConsultaModel
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ConsultaRepository(private val consultaJpaRepository: ConsultaJpaRepository) {

    fun buscarConsultaPorId(id: Long): Consulta? {
        val consultaModel = consultaJpaRepository.findById(id)
        return if (consultaModel.isPresent) ConsultaMapper.toDomain(consultaModel.get()) else null
    }

    fun listarConsultas(): List<Consulta> =
        consultaJpaRepository.findAll().map { ConsultaMapper.toDomain(it) }

    fun criarConsulta(consulta: Consulta): Consulta =
        ConsultaMapper.toDomain(consultaJpaRepository.save(ConsultaMapper.toModel(consulta)))

    fun atualizarConsulta(consulta: Consulta): Consulta =
        ConsultaMapper.toDomain(consultaJpaRepository.save(ConsultaMapper.toModel(consulta)))

    fun listarConsultasPorPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta> =
        consultaJpaRepository.findAllByDataHorarioBetween(start, end).map { ConsultaMapper.toDomain(it) }

    fun cancelarConsulta(consultaId: Long): Consulta? {
        val consultaModel = consultaJpaRepository.findById(consultaId).orElse(null)
        return if (consultaModel != null) {
            consultaModel.status = ConsultaModel.Status.CANCELADA
            ConsultaMapper.toDomain(consultaJpaRepository.save(consultaModel))
        } else {
            null
        }
    }

    fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta> =
        consultaJpaRepository.findAllByPaciente_Id(pacienteId).map { ConsultaMapper.toDomain(it) }

    fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta> =
        consultaJpaRepository.findAllByProfissional_Id(profissionalId).map { ConsultaMapper.toDomain(it) }
}