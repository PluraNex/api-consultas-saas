package com.pluranex.api_consulta_saas.domain.tenant

interface TenantRepository {
    fun salvar(empresa: Tenant): Tenant
    fun buscarPorId(id: Long): Tenant?
    fun listarTodos(): List<Tenant>
}
