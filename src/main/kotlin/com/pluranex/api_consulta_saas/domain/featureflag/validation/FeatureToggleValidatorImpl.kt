package com.pluranex.api_consulta_saas.domain.featureflag.validation


import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.featureflag.EscopoFeature
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import org.springframework.stereotype.Service

/**
 * Implementação padrão do [FeatureToggleValidator], responsável por validar escopos de feature flags.
 */
@Service
class FeatureToggleValidatorImpl : FeatureToggleValidator {

    override fun validarEscopo(
        escopo: EscopoFeature,
        tenantId: TenantId?,
        perfil: PerfilUsuario?,
        userId: String?
    ) {
        when (escopo) {
            EscopoFeature.GLOBAL -> {
                if (tenantId != null || perfil != null || userId != null) {
                    throw BusinessException(
                        BusinessException.BusinessExceptionType.FEATURE_FLAG_CONFIG_INVALIDA,
                        "Escopo GLOBAL não deve conter tenantId, perfil ou userId."
                    )
                }
            }

            EscopoFeature.TENANT -> {
                if (tenantId == null) {
                    throw BusinessException(
                        BusinessException.BusinessExceptionType.FEATURE_FLAG_CONFIG_INVALIDA,
                        "TenantId deve ser informado para escopo TENANT."
                    )
                }
            }

            EscopoFeature.PERFIL -> {
                if (perfil == null) {
                    throw BusinessException(
                        BusinessException.BusinessExceptionType.FEATURE_FLAG_CONFIG_INVALIDA,
                        "Perfil deve ser informado para escopo PERFIL."
                    )
                }
            }

            EscopoFeature.USUARIO -> {
                if (userId.isNullOrBlank()) {
                    throw BusinessException(
                        BusinessException.BusinessExceptionType.FEATURE_FLAG_CONFIG_INVALIDA,
                        "UserId deve ser informado para escopo USUARIO."
                    )
                }
            }
        }
    }
}