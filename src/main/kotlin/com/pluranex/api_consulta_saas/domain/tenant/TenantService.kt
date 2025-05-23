package com.pluranex.api_consulta_saas.domain.tenant

interface TenantService {
    fun criarNovoTenant(nome: String): Tenant
    fun buscarTenantPorId(id: Long): Tenant
    fun listarTodosTenants(): List<Tenant>
}