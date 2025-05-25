package com.pluranex.api_consulta_saas.domain.enums.notificacao

/**
 * Define os canais disponíveis para envio de notificações no sistema.
 *
 * Essa enum é usada tanto para notificações transacionais (ex: lembretes de consulta),
 * quanto para campanhas de CRM (ex: mensagens promocionais).
 *
 * ### Responsabilidades:
 * - Centralizar os meios pelos quais um contato pode ser notificado.
 * - Servir como chave de roteamento para os [NotificacaoProvider]s.
 * - Permitir configurações e preferências por canal (opt-in/opt-out).
 *
 * ### Estratégia recomendada:
 * Cada canal deve ter um **provider** específico que implemente a interface
 * `NotificacaoProvider`, garantindo modularidade e rastreabilidade do envio.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val canal = CanalNotificacao.WHATSAPP
 * val provider = notificacaoProviderFactory.getProvider(canal)
 * provider.enviar(mensagem, contatoDestino)
 * ```
 */
enum class CanalNotificacao {

    /**
     * Envio via WhatsApp, geralmente através de um gateway externo (ex: Twilio, Zenvia).
     */
    WHATSAPP,

    /**
     * Envio de mensagens de e-mail utilizando SMTP ou APIs como SendGrid.
     */
    EMAIL,

    /**
     * Envio de SMS tradicional para celulares, com ou sem resposta.
     */
    SMS,

    /**
     * Chamadas de voz automatizadas, com uso de TTS ou gravações.
     */
    TELEFONE,

    /**
     * Notificações por push, integradas a apps mobile Android/iOS.
     */
    PUSH_NOTIFICATION,

    /**
     * Notificações internas exibidas dentro do sistema (ex: banners ou toasts).
     */
    IN_APP,

    /**
     * Mensagens enviadas via bots no Telegram.
     */
    BOT_TELEGRAM,

    /**
     * Integrações externas via webhooks ou chamadas a APIs de terceiros.
     */
    API_EXTERNA,

    /**
     * Notificações visíveis ao usuário quando ele acessa o portal (paciente, profissional).
     */
    PORTAL_PACIENTE,

    /**
     * Interações automatizadas via chatbot embutido no site ou app.
     */
    CHATBOT
}