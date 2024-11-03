package com.pluranex.api_consulta_saas.infrastructure.repositories.paciente
import com.pluranex.api_consulta_saas.infrastructure.models.PacienteModel
import org.springframework.data.jpa.repository.JpaRepository

interface PacienteJpaRepository : JpaRepository<PacienteModel, Long>