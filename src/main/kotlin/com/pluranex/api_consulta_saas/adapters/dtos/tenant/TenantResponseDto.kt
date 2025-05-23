package com.pluranex.api_consulta_saas.adapters.dtos.tenant

import com.pluranex.api_consulta_saas.domain.tenant.Tenant

data class TenantResponseDto(
    val id: Long?,
    val nome: String
) {
    companion object {
        fun fromDomain(empresa: Tenant) = TenantResponseDto(
            id = empresa.id,
            nome = empresa.nome
        )
    }
}
