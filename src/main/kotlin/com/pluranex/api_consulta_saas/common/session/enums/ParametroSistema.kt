package com.pluranex.api_consulta_saas.common.session.enums

/**
 * Enum que representa os parâmetros configuráveis do sistema,
 * que podem variar por tenant (clínica), por perfil ou ambiente.
 */
enum class ParametroSistema(val descricao: String) {

    // Configurações de notificação
    CANAL_PADRAO_NOTIFICACAO("Canal padrão de envio de notificações"),
    WHATSAPP_ATIVO("WhatsApp habilitado como canal de notificação"),
    EMAIL_ATIVO("E-mail habilitado como canal de notificação"),
    SMS_ATIVO("SMS habilitado como canal de notificação"),

    // Configurações de agendamento
    INTERVALO_PADRAO_CONSULTA("Intervalo padrão entre consultas em minutos"),
    HORARIO_FUNCIONAMENTO_INICIO("Horário inicial de funcionamento da clínica"),
    HORARIO_FUNCIONAMENTO_FIM("Horário final de funcionamento da clínica"),

    // Recursos e limites
    LIMITE_PACIENTES_ATIVOS("Quantidade máxima de pacientes ativos"),
    LIMITE_CONSULTAS_DIARIAS("Quantidade máxima de consultas por dia"),

    // Integrações
    INTEGRACAO_TWILIO_ENABLED("Habilita integração com Twilio"),
    CHAVE_TWILIO("Chave de acesso ao serviço Twilio"),

    // Recursos especiais
    IA_HABILITADA("Flag que indica se a clínica tem acesso a recursos de IA"),
    VIDEOCHAMADA_ATIVA("Flag que habilita recursos de vídeo no sistema"),

    // Comportamento da plataforma
    EXIBIR_LOGO_CUSTOMIZADA("Exibe logo personalizada da clínica no sistema"),
    HABILITAR_MULTI_TENANT("Ativa suporte a múltiplos tenants")
}
