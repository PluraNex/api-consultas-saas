package com.pluranex.api_consulta_saas.domain.crm.filter

import com.pluranex.api_consulta_saas.domain.enums.crm.OrigemContatoCrm
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.LocalDate

/**
 * Representa os critérios de busca e segmentação de perfis de relacionamento no CRM.
 *
 * Pode ser usado para:
 * - Pesquisas em tela de listagem
 * - Geração de campanhas segmentadas
 * - Exportações e análises de público-alvo
 *
 * ### Exemplos de filtro:
 * - Buscar todos os contatos com opt-in no WhatsApp
 * - Buscar contatos que vieram de indicação
 * - Buscar contatos com determinada etiqueta
 */
data class FiltroCrm(

    /** Lista de canais preferenciais (ex: WHATSAPP, EMAIL, SMS) */
    val canais: Set<CanalNotificacao>? = null,

    /** Lista de origens permitidas (ex: FORMULARIO_SITE, INDICACAO) */
    val origens: Set<OrigemContatoCrm>? = null,

    /** Etiquetas para segmentação (ex: "vip", "atrasado", "seguimento-x") */
    val etiquetas: Set<String>? = null,

    /** Indica se deve filtrar apenas contatos ativos */
    val apenasAtivos: Boolean = true,

    /** Data mínima de criação (inclusive) */
    val criadoAPartirDe: LocalDate? = null,

    /** Data máxima de criação (inclusive) */
    val criadoAte: LocalDate? = null
)