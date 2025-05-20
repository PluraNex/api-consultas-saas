package com.pluranex.api_consulta_saas.infrastructure.repositories.empresa

import com.pluranex.api_consulta_saas.infrastructure.models.EmpresaSaudeModel
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaSaudeJpaRepository : JpaRepository<EmpresaSaudeModel, Long>
