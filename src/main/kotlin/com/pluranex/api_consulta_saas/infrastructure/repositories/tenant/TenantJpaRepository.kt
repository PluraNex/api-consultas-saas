package com.pluranex.api_consulta_saas.infrastructure.repositories.tenant

import com.pluranex.api_consulta_saas.infrastructure.models.TenantModel
import org.springframework.data.jpa.repository.JpaRepository

interface TenantJpaRepository : JpaRepository<TenantModel, Long>
