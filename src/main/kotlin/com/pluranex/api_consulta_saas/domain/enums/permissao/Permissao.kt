package com.pluranex.api_consulta_saas.domain.enums.permissao

enum class Permissao(val dominio: String, val descricao: String) {

    // Master/Admin
    GERENCIAR_TENANT("SISTEMA", "Pode criar e gerenciar clínicas (tenants)"),
    GERENCIAR_USUARIOS("SISTEMA", "Pode gerenciar usuários"),
    ADMINISTRAR_SISTEMA("SISTEMA", "Acesso total ao sistema"),
    GESTAO_CLINICA("SISTEMA", "Administração geral da clínica"),

    // Consultas
    VISUALIZAR_CONSULTA("CONSULTA", "Pode visualizar consultas"),
    CRIAR_CONSULTA("CONSULTA", "Pode criar novas consultas"),
    EDITAR_CONSULTA("CONSULTA", "Pode editar consultas existentes"),
    CANCELAR_CONSULTA("CONSULTA", "Pode cancelar consultas"),
    FINALIZAR_CONSULTA("CONSULTA", "Pode finalizar consultas"),

    // Pacientes
    VISUALIZAR_PACIENTE("PACIENTE", "Pode visualizar pacientes"),
    CRIAR_PACIENTE("PACIENTE", "Pode cadastrar novos pacientes"),
    EDITAR_PACIENTE("PACIENTE", "Pode editar pacientes"),
    EXCLUIR_PACIENTE("PACIENTE", "Pode excluir pacientes")
}
