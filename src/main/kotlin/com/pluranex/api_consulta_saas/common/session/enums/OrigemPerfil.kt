package com.pluranex.api_consulta_saas.common.session.enums

/**
 * Representa a origem do perfil do usuário logado no sistema,
 * útil para distinguir comportamentos ou acessos por contexto organizacional.
 *
 * Essa informação geralmente vem de headers como `X-Perfil-BD` ou do token JWT.
 */
enum class OrigemPerfil {
    ADMINISTRACAO_FINANCEIRA,
    ATENDENTE_CLINICA,
    PROFISSIONAL_SAUDE,
    CLIENTE_PACIENTE,
    SISTEMA_INTEGRACAO,
    SUPERVISAO,
    DESCONHECIDA,
    SISTEMA,
    TRial
}
