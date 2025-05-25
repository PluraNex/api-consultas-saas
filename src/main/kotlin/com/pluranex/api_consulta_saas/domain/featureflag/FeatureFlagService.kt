package com.pluranex.api_consulta_saas.domain.featureflag


import com.pluranex.api_consulta_saas.domain.enums.featureflag.FeatureToggle
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.enums.featureflag.EscopoFeature
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId


interface FeatureFlagService {

    fun ativarFeature(
        toggle: FeatureToggle,
        escopo: EscopoFeature,
        tenantId: TenantId? = null,
        perfil: PerfilUsuario? = null,
        userId: UserId? = null,
        alteradoPor: String
    ): FeatureToggleStatus

    fun desativarFeature(
        toggle: FeatureToggle,
        escopo: EscopoFeature,
        tenantId: TenantId? = null,
        perfil: PerfilUsuario? = null,
        userId: UserId? = null,
        alteradoPor: String
    ): FeatureToggleStatus

    fun buscarStatus(
        toggle: FeatureToggle,
        tenantId: TenantId? = null,
        perfil: PerfilUsuario? = null,
        userId: UserId? = null
    ): FeatureToggleStatus?

    fun listarTodasAtivasPorTenant(tenantId: TenantId): List<FeatureToggleStatus>
}
