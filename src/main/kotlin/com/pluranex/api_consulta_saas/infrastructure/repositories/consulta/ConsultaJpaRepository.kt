package com.pluranex.api_consulta_saas.infrastructure.repositories.consulta

import com.pluranex.api_consulta_saas.infrastructure.models.ConsultaModel
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface ConsultaJpaRepository : JpaRepository<ConsultaModel, Long> {
    fun findAllByDataHorarioBetween(start: LocalDateTime, end: LocalDateTime): List<ConsultaModel>

    fun findAllByPaciente_Id(pacienteId: Long): List<ConsultaModel>


    fun findAllByProfissional_Id(profissionalId: Long): List<ConsultaModel>
}