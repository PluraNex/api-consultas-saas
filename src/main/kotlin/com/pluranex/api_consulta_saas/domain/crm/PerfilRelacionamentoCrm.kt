package com.pluranex.api_consulta_saas.domain.crm

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.crm.contato.ContatoCrm
import com.pluranex.api_consulta_saas.domain.enums.crm.OrigemContatoCrm
import java.time.LocalDateTime

/**
 * Representa um perfil ativo de relacionamento dentro do módulo de CRM.
 *
 * Este perfil estende a entidade [com.pluranex.api_consulta_saas.domain.crm.contato.ContatoCrm] com informações estratégicas
 * para relacionamento, engajamento e campanhas.
 *
 * ### Responsabilidades:
 * - Associar um contato a um tenant (clínica/unidade)
 * - Registrar a origem do lead ou cliente
 * - Gerenciar preferências de contato (opt-in por canal)
 * - Armazenar o histórico de interações realizadas
 * - Agrupar contatos por etiquetas livres para campanhas e segmentações
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val perfilCrm = PerfilRelacionamentoCrm(
 *     tenantId = TenantId("clinica-xyz"),
 *     contato = contato,
 *     origem = OrigemContatoCrm.INDICACAO,
 *     preferencias = listOf(PreferenciaCanalCrm(...)),
 *     etiquetas = setOf("VIP", "BlackFriday")
 * )
 * ```
 *
 * @property id Identificador único do perfil no sistema
 * @property tenantId Identificador do tenant (clínica/unidade)
 * @property contatoCrm Entidade de contato principal (domínio `contato`)
 * @property origem Origem do lead ou canal de aquisição
 * @property preferencias Preferências de opt-in por canal de contato
 * @property interacoes Histórico de interações com este contato
 * @property etiquetas Etiquetas livres utilizadas para segmentações
 * @property criadoEm Data de criação deste perfil no CRM
 * @property criadoPor Usuário ou sistema que criou o perfil
 */
data class PerfilRelacionamentoCrm(
    val id: Long? = null,
    val tenantId: TenantId,
    val contato: ContatoCrm,
    val origem: OrigemContatoCrm = OrigemContatoCrm.CADASTRO_MANUAL,
    val preferencias: List<PreferenciaCanalCrm> = emptyList(),
    val interacoes: List<InteracaoCrm> = emptyList(),
    val etiquetas: Set<String> = emptySet(),
    val criadoEm: LocalDateTime = LocalDateTime.now(),
    val criadoPor: String? = null
)
