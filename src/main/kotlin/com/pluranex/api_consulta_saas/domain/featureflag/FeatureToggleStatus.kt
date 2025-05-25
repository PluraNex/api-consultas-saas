package com.pluranex.api_consulta_saas.domain.featureflag

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.featureflag.EscopoFeature
import com.pluranex.api_consulta_saas.domain.enums.featureflag.FeatureToggle
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import java.time.LocalDateTime

/**
 * Representa o estado de ativação de uma `FeatureToggle` dentro de um determinado escopo.
 *
 * Permite granularidade na ativação de funcionalidades experimentais ou condicionais,
 * controladas por tenant, perfil ou usuário.
 *
 * ### Responsabilidades:
 * - Armazenar o status atual de uma feature para determinado escopo
 * - Registrar o contexto de ativação: tenant, perfil, usuário e operador
 * - Suportar auditoria e gestão de funcionalidades por ambiente
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val status = FeatureToggleStatus(
 *     escopo = EscopoFeature.PERFIL,
 *     toggle = FeatureToggle.VIDEOCHAMADA_SEGURA,
 *     habilitado = true,
 *     tenantId = TenantId("clinica-123"),
 *     perfil = PerfilUsuario.MEDICO,
 *     alteradoPor = "admin@clinica.com"
 * )
 * ```
 *
 * @property id Identificador interno do registro de status
 * @property escopo Escopo de aplicação da flag (GLOBAL, TENANT, PERFIL, USUARIO)
 * @property toggle Feature sendo controlada
 * @property habilitado Se a funcionalidade está habilitada ou não
 * @property tenantId Identificador da clínica (se escopo for por tenant)
 * @property perfil Perfil funcional associado à ativação (se aplicável)
 * @property userId Usuário específico (se escopo for USUARIO)
 * @property alteradoPor Usuário ou sistema responsável pela alteração
 * @property criadoEm Timestamp da criação ou última alteração
 */
data class FeatureToggleStatus(
    val id: Long? = null,
    val escopo: EscopoFeature,
    val toggle: FeatureToggle,
    val habilitado: Boolean,
    val tenantId: TenantId? = null,
    val perfil: PerfilUsuario? = null,
    val userId: UserId? = null,
    val alteradoPor: String? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now()
)