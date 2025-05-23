package com.pluranex.api_consulta_saas.application.tenant

import com.pluranex.api_consulta_saas.domain.tenant.*
import com.pluranex.api_consulta_saas.domain.tenant.usecase.BuscarTenantUseCase
import com.pluranex.api_consulta_saas.domain.tenant.usecase.CriarTenantUseCase
import com.pluranex.api_consulta_saas.domain.tenant.usecase.ListarTenantUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TenantServiceImpl(
    private val criarTenantUseCase: CriarTenantUseCase,
    private val buscarTenantUseCase: BuscarTenantUseCase,
    private val listarTenantUseCase: ListarTenantUseCase
) : TenantService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(TenantServiceImpl::class.java)
    }

    override fun criarNovoTenant(nome: String): Tenant {
        logger.info("Iniciando criação do tenant com nome: $nome")
        val tenant = criarTenantUseCase.executar(nome)
        logger.info("Tenant criado com ID: ${tenant.id}")
        return tenant
    }

    override fun buscarTenantPorId(id: Long): Tenant {
        logger.info("Buscando tenant com ID: $id")
        return buscarTenantUseCase.executar(id)
    }

    override fun listarTodosTenants(): List<Tenant> {
        logger.info("Listando todos os tenants")
        return listarTenantUseCase.executar()
    }
}
