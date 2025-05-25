package com.pluranex.api_consulta_saas.domain.featureflag.validation


import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.featureflag.EscopoFeature
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario

/**
 * Contrato para validações relacionadas à ativação de feature flags no sistema.
 *
 * Garante consistência e regras de integridade de dados relacionadas aos escopos de ativação.
 */
interface FeatureToggleValidator {

    /**
     * Valida a consistência entre o escopo fornecido e os parâmetros associados.
     *
     * @param escopo Escopo de ativação da feature
     * @param tenantId Identificador do tenant, se aplicável
     * @param perfil Perfil funcional do usuário, se aplicável
     * @param userId Identificador do usuário, se aplicável
     */
    fun validarEscopo(
        escopo: EscopoFeature,
        tenantId: TenantId? = null,
        perfil: PerfilUsuario? = null,
        userId: String? = null
    )
}
