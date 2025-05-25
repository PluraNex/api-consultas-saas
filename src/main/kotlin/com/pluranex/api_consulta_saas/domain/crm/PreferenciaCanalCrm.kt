package com.pluranex.api_consulta_saas.domain.crm

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.LocalDateTime

/**
 * Representa a preferência explícita de um contato quanto ao recebimento de comunicações via um canal específico.
 *
 * Utilizada no contexto do CRM para controle de **opt-in** e **opt-out**, garantindo conformidade com
 * legislações como a LGPD e alinhamento com práticas éticas de marketing.
 *
 * ### Responsabilidades:
 * - Armazenar a aceitação ou recusa do contato para determinado canal de comunicação
 * - Rastrear data, origem e responsável pelo registro da preferência
 * - Permitir observações contextuais (ex: consentimento verbal, via formulário, por solicitação)
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val preferencia = PreferenciaCanalCrm(
 *     tenantId = TenantId("clinica-abc"),
 *     canal = CanalNotificacao.WHATSAPP,
 *     optIn = true,
 *     observacao = "Consentimento verbal durante a consulta",
 *     registradoPor = "atendente@clinica.com"
 * )
 * ```
 *
 * @property id Identificador da preferência registrada
 * @property tenantId Identificador do tenant ao qual o contato está associado
 * @property canal Canal de comunicação (ex: WHATSAPP, EMAIL, SMS)
 * @property optIn Indica se o contato permitiu receber notificações neste canal
 * @property observacao Comentário livre sobre a origem ou contexto do consentimento
 * @property registradoEm Data e hora do registro da preferência (default: agora)
 * @property registradoPor Identificador do sistema ou pessoa que registrou a preferência
 */
data class PreferenciaCanalCrm(
    val id: Long? = null,
    val tenantId: TenantId,
    val canal: CanalNotificacao,
    val optIn: Boolean = true,
    val observacao: String? = null,
    val registradoEm: LocalDateTime = LocalDateTime.now(),
    val registradoPor: String? = null
)
