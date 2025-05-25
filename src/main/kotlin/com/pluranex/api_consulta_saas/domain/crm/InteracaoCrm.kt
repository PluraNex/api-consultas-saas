package com.pluranex.api_consulta_saas.domain.crm

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.LocalDateTime

/**
 * Representa uma interação registrada com um contato no contexto de CRM.
 *
 * Cada instância corresponde a um evento concreto de comunicação — como envio de mensagem,
 * ligação, e-mail ou outro tipo de contato — realizado por um operador ou sistema.
 *
 * ### Responsabilidades:
 * - Rastrear ações de comunicação com o contato
 * - Armazenar canal, conteúdo e data da interação
 * - Identificar o autor da ação e o tenant relacionado
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val interacao = InteracaoCrm(
 *     tenantId = TenantId("clinica123"),
 *     canal = CanalNotificacao.WHATSAPP,
 *     mensagem = "Olá! Confirmando seu agendamento para amanhã.",
 *     realizadaPor = "atendente@clinica.com"
 * )
 * ```
 *
 * @property id Identificador único da interação (gerado pelo banco)
 * @property tenantId Identificador da clínica ou unidade (multi-tenant)
 * @property canal Canal de comunicação utilizado (ex: WHATSAPP, EMAIL, SMS)
 * @property mensagem Conteúdo ou observação da interação
 * @property realizadaEm Data e hora da interação (default: agora)
 * @property realizadaPor Identificador do usuário ou sistema que realizou a ação
 */
data class InteracaoCrm(
    val id: Long? = null,
    val tenantId: TenantId,
    val canal: CanalNotificacao,
    val mensagem: String,
    val realizadaEm: LocalDateTime = LocalDateTime.now(),
    val realizadaPor: String? = null
)
