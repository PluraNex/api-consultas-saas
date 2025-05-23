package com.pluranex.api_consulta_saas.domain.tenant.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.domain.tenant.TenantRepository
import com.pluranex.api_consulta_saas.domain.tenant.validation.TenantValidator
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_EMPRESA_SAUDE
import org.slf4j.LoggerFactory

@UseCase
class CriarTenantUseCase(
    private val tenantRepository: TenantRepository,
    private val tenantValidator: TenantValidator
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CriarTenantUseCase::class.java)
    }

    fun executar(nome: String): Tenant {
        logger.info("Iniciando criação de empresa de saúde com nome: $nome")

        tenantValidator.validarNome(nome)

        return try {
            tenantRepository.salvar(Tenant(nome = nome)).also {
                logger.info("Empresa criada com sucesso. ID: ${it.id}")
            }
        } catch (e: Exception) {
            logger.error("Erro ao criar empresa de saúde: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_CRIAR_EMPRESA_SAUDE,
                "Erro ao criar empresa de saúde com nome: $nome",
                e
            )
        }
    }
}
