package com.pluranex.api_consulta_saas.infrastructure.repositories.tenant

import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.domain.tenant.TenantRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.TenantMapper
import org.springframework.stereotype.Repository

@Repository
class TenantRepositoryImpl(
    private val tenantJpaRepository: TenantJpaRepository
) : TenantRepository {

    override fun salvar(empresa: Tenant): Tenant {
        val model = TenantMapper.toModel(empresa)
        val saved = tenantJpaRepository.save(model)
        return TenantMapper.toDomain(saved)
    }

    override fun buscarPorId(id: Long): Tenant? {
        return tenantJpaRepository.findById(id).orElse(null)?.let { TenantMapper.toDomain(it) }
    }

    override fun listarTodos(): List<Tenant> {
        return tenantJpaRepository.findAll().map { TenantMapper.toDomain(it) }
    }
}
