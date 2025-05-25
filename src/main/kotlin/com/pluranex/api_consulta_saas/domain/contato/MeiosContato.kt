package com.pluranex.api_consulta_saas.domain.contato

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao

/**
 * Representa os meios de comunicação disponíveis com uma pessoa ou entidade.
 *
 * Este objeto de valor pode ser embutido em entidades como `Paciente`, `Profissional`,
 * `Clínica`, ou `ContatoCrm` para fornecer dados reutilizáveis de telefone, email e WhatsApp.
 *
 * ### Responsabilidades:
 * - Armazenar canais de contato disponíveis.
 * - Definir o canal preferencial para comunicações.
 *
 * @property telefone Número principal de contato.
 * @property email Endereço de e-mail (opcional).
 * @property whatsapp Número do WhatsApp (opcional).
 * @property canalPreferencial Canal mais indicado para comunicação automatizada.
 */
data class MeiosContato(
    val telefone: String,
    val email: String?,
    val whatsapp: String?,
    val canalPreferencial: CanalNotificacao = CanalNotificacao.WHATSAPP
)
