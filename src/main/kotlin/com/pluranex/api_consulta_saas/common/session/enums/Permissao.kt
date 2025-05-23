package com.pluranex.api_consulta_saas.common.session.enums

/**
 * Enum que representa todas as permissões possíveis no sistema.
 * Utilizado para controle de acesso baseado em escopo e papel.
 */
enum class Permissao(val descricao: String) {

    // Consultas
    VISUALIZAR_CONSULTA("Pode visualizar consultas"),
    CRIAR_CONSULTA("Pode criar novas consultas"),
    EDITAR_CONSULTA("Pode editar consultas existentes"),
    CANCELAR_CONSULTA("Pode cancelar consultas"),
    FINALIZAR_CONSULTA("Pode finalizar consultas"),

    // Pacientes
    VISUALIZAR_PACIENTE("Pode visualizar pacientes"),
    CRIAR_PACIENTE("Pode cadastrar novos pacientes"),
    EDITAR_PACIENTE("Pode editar informações dos pacientes"),
    EXCLUIR_PACIENTE("Pode remover pacientes do sistema"),

    // Profissionais
    VISUALIZAR_PROFISSIONAL("Pode visualizar profissionais"),
    GERENCIAR_PROFISSIONAL("Pode criar/editar/excluir profissionais"),

    // Notificações
    VISUALIZAR_NOTIFICACAO("Pode visualizar notificações"),
    ENVIAR_NOTIFICACAO("Pode enviar notificações"),
    CONFIGURAR_NOTIFICACAO("Pode configurar canais e regras de notificação"),

    // Configurações
    GERENCIAR_CONFIGURACOES("Pode gerenciar parâmetros e configurações globais"),
    GERENCIAR_USUARIOS("Pode criar/editar/excluir usuários do sistema"),

    // Administração
    ADMINISTRAR_SISTEMA("Acesso total ao sistema"),
    GESTAO_CLINICA("Acesso administrativo à clínica"),

    //Medicos
    GERENCIAR_MEDICO("Pode criar/editar/excluir médicos"),
    GERENCIAR_PRONTUARIO("Pode criar/editar/excluir prontuários"),

    // Tenants
    GERENCIAR_TENANT("Pode criar e gerenciar clínicas"),
}
