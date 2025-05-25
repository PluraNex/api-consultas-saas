package com.pluranex.api_consulta_saas.domain.crm.auditoria

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.LocalDateTime

/**
 * Representa um registro histórico de alteração no consentimento (opt-in/opt-out)
 * para comunicação via um canal específico, no contexto de CRM.
 *
 * Essa estrutura é essencial para rastreamento e compliance com políticas de privacidade
 * como LGPD, GDPR e boas práticas de relacionamento com clientes.
 *
 * ### Responsabilidades:
 * - Armazenar mudanças explícitas de consentimento (opt-in/opt-out) por canal
 * - Registrar o motivo, autor e momento da alteração
 * - Permitir auditoria e rastreabilidade legal
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val historico = HistoricoPreferenciaCanalCrm(
 *     tenantId = TenantId("clinica123"),
 *     canal = CanalNotificacao.EMAIL,
 *     optInAnterior = true,
 *     optInAtual = false,
 *     motivo = "Descadastro solicitado via formulário",
 *     alteradoPor = "atendente@sistema.com"
 * )
 * ```
 *
 * @property id Identificador único do registro histórico (opcional)
 * @property tenantId Identificador do tenant (clínica) responsável
 * @property canal Canal de comunicação afetado (ex: EMAIL, WHATSAPP, SMS)
 * @property optInAnterior Valor anterior de consentimento (antes da alteração)
 * @property optInAtual Valor atualizado de consentimento (após a alteração)
 * @property motivo Descrição ou justificativa da mudança
 * @property alteradoEm Data e hora da alteração (default: agora)
 * @property alteradoPor Identificador do operador ou sistema que realizou a mudança
 */
data class HistoricoPreferenciaCanalCrm(
    val id: Long? = null,
    val tenantId: TenantId,
    val canal: CanalNotificacao,
    val optInAnterior: Boolean,
    val optInAtual: Boolean,
    val motivo: String,
    val alteradoEm: LocalDateTime = LocalDateTime.now(),
    val alteradoPor: String? = null
)