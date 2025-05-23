package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.infrastructure.models.TenantModel

object TenantMapper {

    fun toDomain(model: TenantModel): Tenant =
        Tenant(id = model.id, nome = model.nome)

    fun toModel(entity: Tenant): TenantModel =
        TenantModel(id = entity.id, nome = entity.nome)
}
