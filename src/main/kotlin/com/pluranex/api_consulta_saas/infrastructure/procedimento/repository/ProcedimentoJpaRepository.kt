package com.pluranex.api_consulta_saas.infrastructure.procedimento.repository

import com.pluranex.api_consulta_saas.infrastructure.procedimento.model.ProcedimentoModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProcedimentoJpaRepository : JpaRepository<ProcedimentoModel, UUID>

