package com.pluranex.api_consulta_saas.domain.enums.usuario

import com.pluranex.api_consulta_saas.common.session.enums.OrigemPerfil

/**
 * Enum que representa os perfis funcionais de usuário no sistema.
 *
 * Utilizado para definir permissões padrão, comportamento de sessão e escopo de atuação.
 *
 * ### Perfis disponíveis:
 * - `MASTER` → Superusuário com acesso global irrestrito
 * - `ADMIN` → Administrador do tenant (clínica)
 * - `MEDICO` → Profissional de saúde
 * - `PACIENTE` → Cliente/paciente
 * - `ATENDENTE` → Usuário auxiliar ou recepção
 *
 * ### Responsabilidades:
 * - Auxiliar na geração de sessão JWT (perfil e origem)
 * - Controlar visibilidade e escopos padrão
 * - Fornecer suporte para validação de acesso (`isAdmin`, `isMaster`)
 */
enum class PerfilUsuario {

    MASTER,
    ADMIN,
    MEDICO,
    PACIENTE,
    ATENDENTE;

    /**
     * Indica se o perfil possui privilégios administrativos.
     * Ex: ADMIN ou MASTER.
     */
    val isAdmin: Boolean
        get() = this == MASTER || this == ADMIN

    /**
     * Indica se o perfil é o superusuário do sistema (nível máximo de permissão).
     */
    val isMaster: Boolean
        get() = this == MASTER

    /**
     * Mapeia o perfil para sua [OrigemPerfil] correspondente.
     * Utilizado para enriquecer a sessão do usuário.
     */
    val origem: OrigemPerfil
        get() = when (this) {
            MASTER -> OrigemPerfil.SISTEMA
            ADMIN -> OrigemPerfil.ADMINISTRACAO_FINANCEIRA
            MEDICO -> OrigemPerfil.PROFISSIONAL_SAUDE
            PACIENTE -> OrigemPerfil.CLIENTE_PACIENTE
            ATENDENTE -> OrigemPerfil.ATENDENTE_CLINICA
        }
}
