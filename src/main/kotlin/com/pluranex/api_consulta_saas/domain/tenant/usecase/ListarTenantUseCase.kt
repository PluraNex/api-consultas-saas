package com.pluranex.api_consulta_saas.domain.tenant.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.domain.tenant.TenantRepository
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_LISTAR_EMPRESAS
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.EMPRESA_SAUDE_NOT_FOUND
import org.slf4j.LoggerFactory

@UseCase
class ListarTenantUseCase(
    private val tenantRepository: TenantRepository
) {

    companion object {
        private val logger = LoggerFactory.getLogger(ListarTenantUseCase::class.java)
    }

    fun executar(): List<Tenant> {
        logger.info("Executando listagem de empresas de saúde")

        return try {
            tenantRepository.listarTodos()
                .takeIf { it.isNotEmpty() }
                ?: throw NotFoundException(
                    EMPRESA_SAUDE_NOT_FOUND,
                    "Nenhuma empresa de saúde encontrada no sistema."
                )
        } catch (e: Exception) {
            logger.error("Erro ao listar empresas de saúde: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_LISTAR_EMPRESAS,
                "Erro ao listar empresas de saúde: ${e.message}",
                e
            )
        }
    }
}
