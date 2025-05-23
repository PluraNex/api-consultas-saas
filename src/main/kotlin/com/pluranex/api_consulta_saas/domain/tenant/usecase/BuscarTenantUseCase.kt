package com.pluranex.api_consulta_saas.domain.tenant.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.domain.tenant.TenantRepository
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.EMPRESA_SAUDE_NOT_FOUND
import org.slf4j.LoggerFactory

@UseCase
class BuscarTenantUseCase(
    private val tenantRepository: TenantRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(BuscarTenantUseCase::class.java)
    }

    fun executar(id: Long): Tenant {
        logger.info("Executando busca da empresa de saúde com ID: $id")

        return  tenantRepository.buscarPorId(id)
            ?: throw NotFoundException(
                EMPRESA_SAUDE_NOT_FOUND,
                "Empresa de saúde com ID $id não encontrada."
            )
    }
}
