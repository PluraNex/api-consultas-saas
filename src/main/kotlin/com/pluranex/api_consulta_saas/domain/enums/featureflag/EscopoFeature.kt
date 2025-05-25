package com.pluranex.api_consulta_saas.domain.enums.featureflag

/**
 * Define o escopo de aplicação de uma feature no sistema.
 *
 * Esse enum é utilizado para indicar em qual nível a funcionalidade pode ser ativada ou desativada,
 * permitindo granularidade no controle de acesso e personalização do sistema.
 *
 * ### Escopos disponíveis:
 *
 * - `GLOBAL`: A feature está disponível para todos os usuários e tenants do sistema.
 * - `TENANT`: A feature é ativada por clínica/empresa (tenant).
 * - `PERFIL`: A feature é ativada para um determinado tipo de perfil de usuário.
 * - `USUARIO`: A feature é ativada individualmente para um usuário específico.
 *
 * Esse tipo é útil para construir uma lógica de fallback e priorização, como:
 * `USUARIO > PERFIL > TENANT > GLOBAL`.
 */
enum class EscopoFeature {
    /** Disponível globalmente para todo o sistema, sem restrição de tenant ou perfil */
    GLOBAL,

    /** Ativada por tenant (clínica/empresa) — escopo mais comum em ambientes multitenant */
    TENANT,

    /** Ativada por tipo de perfil de usuário (ex: ADMIN, ATENDENTE, MÉDICO) */
    PERFIL,

    /** Ativada individualmente por usuário (granularidade máxima) */
    USUARIO
}
