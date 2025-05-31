package com.pluranex.api_consulta_saas.domain.enums.usuario

/**
 * Representa a origem do perfil do usuário logado no sistema,
 * útil para distinguir comportamentos ou acessos por contexto organizacional.
 *
 * Essa informação geralmente vem de headers como `X-Perfil-BD` ou do token JWT.
 */
enum class OrigemPerfil {
    /** Administração financeira ou geral da clínica (ex: ADMIN, DIRETOR) */
    ADMINISTRACAO_FINANCEIRA,

    /** Recepção, agendamento e suporte ao atendimento */
    ATENDENTE_CLINICA,

    /** Profissionais habilitados para realizar atendimento clínico */
    PROFISSIONAL_SAUDE,

    /** Usuário final (paciente logado) */
    CLIENTE_PACIENTE,

    /** Usuários técnicos internos ao sistema (ex: MASTER, automações) */
    SISTEMA,

    /** Integrações com ERPs, prontuários ou terceiros externos */
    SISTEMA_INTEGRACAO,

    /** Supervisores, coordenadores clínicos ou acadêmicos */
    SUPERVISAO,

    /** Fallback em caso de perfil não resolvido */
    DESCONHECIDA,
}