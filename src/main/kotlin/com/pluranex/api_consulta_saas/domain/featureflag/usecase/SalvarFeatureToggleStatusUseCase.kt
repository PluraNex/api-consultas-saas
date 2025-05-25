package com.pluranex.api_consulta_saas.domain.featureflag.usecase

import com.pluranex.api_consulta_saas.common.annotations.UseCase
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType
import com.pluranex.api_consulta_saas.domain.featureflag.FeatureToggleStatus
import com.pluranex.api_consulta_saas.domain.featureflag.validation.FeatureToggleValidator
import org.slf4j.LoggerFactory

/**
 * Caso de uso responsável por persistir o estado de uma feature toggle.
 *
 * Executa validações de integridade e encapsula o salvamento seguro
 * no repositório, com suporte a log e tratamento de falhas técnicas.
 *
 * ### Responsabilidades:
 * - Validar o objeto `FeatureToggleStatus` antes de persistir
 * - Capturar exceções de infraestrutura e reempacotar como `IntegrationException`
 */
//@UseCase
class SalvarFeatureToggleStatusUseCase(
//    private val repository: FeatureToggleRepository,
//    private val validator: FeatureToggleValidator
) {
//
//    private val logger = LoggerFactory.getLogger(SalvarFeatureToggleStatusUseCase::class.java)
//
//    /**
//     * Persiste o status de uma feature toggle, após validação.
//     *
//     * @param status Instância de `FeatureToggleStatus` com dados completos
//     * @return FeatureToggleStatus persistido
//     * @throws IntegrationException Em caso de erro técnico ao salvar
//     */
//    fun executar(status: FeatureToggleStatus): FeatureToggleStatus {
//        validator.validarEscopo(status.escopo, status.tenantId, status.perfil, status.userId)
//
//        return try {
//            repository.salvar(status).also {
//                logger.info("FeatureToggle ${status.toggle} salva com sucesso no escopo ${status.escopo}")
//            }
//        } catch (e: Exception) {
//            logger.error("Erro ao salvar FeatureToggleStatus: ${e.message}", e)
//            throw IntegrationException(
//                IntegrationExceptionType.ERRO_AO_SALVAR_FEATURE_FLAG,
//                "Falha ao salvar status da feature ${status.toggle} para escopo ${status.escopo}",
//                e
//           )
//        }
//    }
}
