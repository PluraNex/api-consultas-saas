package com.pluranex.api_consulta_saas.infrastructure.repositories.profissional

import com.pluranex.api_consulta_saas.infrastructure.models.ProfissionalModel
import org.springframework.data.jpa.repository.JpaRepository

interface ProfissionalJpaRepository : JpaRepository<ProfissionalModel, Long>