package com.pluranex.api_consulta_saas.domain.plano.auditoria

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import java.time.LocalDateTime

/**
 * Entidade de auditoria que registra cada alteração de plano contratual de um [Tenant].
 *
 * Utilizada para:
 * - Rastrear upgrades e downgrades.
 * - Exibir histórico de mudanças no painel administrativo.
 * - Fins legais, de faturamento e compliance.
 *
 * ### Regras:
 * - [planoAnterior] pode ser `null` no primeiro registro do tenant.
 * - [planoNovo] nunca deve ser `null`.
 *
 * ### Exemplos de uso:
 * - Gerado automaticamente ao invocar `Tenant.atualizarPlano(...)`.
 * - Acessado por administradores no histórico de contrato.
 *
 * @property id Identificador interno do registro de auditoria.
 * @property tenantId Referência ao tenant afetado pela mudança.
 * @property planoAnterior Plano anterior à alteração (pode ser `null` no primeiro contrato).
 * @property planoNovo Plano que entrou em vigor com esta alteração.
 * @property alteradoPor Identificador ou nome do agente que efetuou a mudança (usuário ou sistema).
 * @property motivo Justificativa ou comentário opcional sobre a alteração.
 * @property criadoEm Timestamp da alteração (preenchido automaticamente).
 */
data class PlanoContratadoHistorico(
    val id: Long? = null,
    val tenantId: TenantId,
    val planoAnterior: PlanoTenant? = null,
    val planoNovo: PlanoTenant,
    val alteradoPor: String,
    val motivo: String? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now()
)
