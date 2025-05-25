package com.pluranex.api_consulta_saas.domain.crm

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao

/**
 * Representa um destino de envio para notificações ou campanhas.
 * Mantido fora da entidade de notificação para promover reutilização e isolamento de domínio.
 */
data class ContatoDestinoCrm(
    val contatoId: Long,
    val canalPreferencial: CanalNotificacao,
    val nomeReferencia: String? = null,
    val observacao: String? = null
)

/**
 * Futuras especializações podem incluir:
 * - Opt-in / Opt-out por canal
 * - Preferências horárias
 * - Localização / Fuso horário
 * - Histórico de envio por contato
 */