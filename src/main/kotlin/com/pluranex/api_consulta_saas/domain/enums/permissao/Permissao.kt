package com.pluranex.api_consulta_saas.domain.enums.permissao

enum class Permissao(val dominio: String, val descricao: String) {

    // ------------------------ SISTEMA / MASTER / ADMIN ------------------------
    GERENCIAR_TENANT("SISTEMA", "Pode criar e gerenciar clínicas (tenants)"),
    GERENCIAR_USUARIOS("SISTEMA", "Pode gerenciar usuários"),
    ADMINISTRAR_SISTEMA("SISTEMA", "Acesso total ao sistema"),
    GESTAO_CLINICA("SISTEMA", "Administração geral da clínica"),

    // ------------------------ CONSULTAS ------------------------
    VISUALIZAR_CONSULTA("CONSULTA", "Pode visualizar consultas"),
    CRIAR_CONSULTA("CONSULTA", "Pode criar novas consultas"),
    EDITAR_CONSULTA("CONSULTA", "Pode editar consultas existentes"),
    CANCELAR_CONSULTA("CONSULTA", "Pode cancelar consultas"),
    FINALIZAR_CONSULTA("CONSULTA", "Pode finalizar consultas"),

    // ------------------------ PACIENTES ------------------------
    VISUALIZAR_PACIENTE("PACIENTE", "Pode visualizar pacientes"),
    CRIAR_PACIENTE("PACIENTE", "Pode cadastrar novos pacientes"),
    EDITAR_PACIENTE("PACIENTE", "Pode editar pacientes"),
    EXCLUIR_PACIENTE("PACIENTE", "Pode excluir pacientes"),

    // ------------------------ PROFISSIONAIS ------------------------
    GERENCIAR_PROFISSIONAIS("CLINICA", "Pode cadastrar e gerenciar profissionais de saúde"),
    ASSOCIAR_PROFISSIONAL_PACIENTE("CLINICA", "Pode vincular pacientes a profissionais"),
    GERENCIAR_EQUIPE("CLINICA", "Pode criar e gerenciar equipes multiprofissionais"),

    // ------------------------ PROCEDIMENTOS ------------------------
    VISUALIZAR_PROCEDIMENTO("PROCEDIMENTO", "Pode visualizar procedimentos"),
    CRIAR_PROCEDIMENTO("PROCEDIMENTO", "Pode cadastrar novos procedimentos"),
    EDITAR_PROCEDIMENTO("PROCEDIMENTO", "Pode editar procedimentos existentes"),
    EXCLUIR_PROCEDIMENTO("PROCEDIMENTO", "Pode remover procedimentos"),

    // ------------------------ AGENDAMENTOS ------------------------
    VISUALIZAR_AGENDAMENTO("AGENDA", "Pode visualizar a agenda"),
    GERENCIAR_AGENDAMENTO("AGENDA", "Pode gerenciar toda a agenda da clínica"),

    // ------------------------ PRONTUÁRIO E DOCUMENTOS ------------------------
    VISUALIZAR_PRONTUARIO("PRONTUARIO", "Pode visualizar prontuários dos pacientes"),
    EDITAR_PRONTUARIO("PRONTUARIO", "Pode registrar evoluções e anexar documentos"),
    EXPORTAR_PRONTUARIO("PRONTUARIO", "Pode exportar ou imprimir prontuários"),

    // ------------------------ FINANCEIRO ------------------------
    VISUALIZAR_FINANCEIRO("FINANCEIRO", "Pode visualizar informações financeiras"),
    GERENCIAR_PAGAMENTOS("FINANCEIRO", "Pode gerenciar pagamentos e recebimentos"),
    GERENCIAR_REPASSES("FINANCEIRO", "Pode gerenciar repasses a profissionais"),

    // ------------------------ FATURAMENTO E PLANOS ------------------------
    VISUALIZAR_FATURAMENTO("FATURAMENTO", "Pode visualizar faturas e cobranças"),
    GERENCIAR_PLANO("FATURAMENTO", "Pode alterar plano da clínica"),

    // ------------------------ CONFIGURAÇÕES ------------------------
    EDITAR_PARAMETROS_CLINICA("CONFIGURACAO", "Pode editar configurações e parâmetros da clínica"),
    GERENCIAR_INTEGRACOES("CONFIGURACAO", "Pode configurar integrações com terceiros"),

    // ------------------------ INTELIGÊNCIA E IA ------------------------
    ACESSAR_IA("RECURSOS", "Pode usar funcionalidades baseadas em inteligência artificial"),
    GERAR_RELATORIOS("RECURSOS", "Pode gerar relatórios analíticos"),

    // ------------------------ CONTEÚDO E BLOG ------------------------
    GERENCIAR_BLOG("CONTEUDO", "Pode criar e editar postagens no blog da clínica"),
    GERENCIAR_MATERIAIS("CONTEUDO", "Pode adicionar e organizar materiais educativos"),

    // ------------------------ ADMIN (SUPERUSUÁRIO / BACKOFFICE) ------------------------
    VISUALIZAR_METRICAS("ADMIN", "Pode visualizar métricas gerais"),
    VISUALIZAR_TENANTS("ADMIN", "Pode visualizar todos os tenants"),
    ATUALIZAR_STATUS_TENANT("ADMIN", "Pode ativar ou desativar tenants"),
    CRIAR_TENANT("ADMIN", "Pode criar tenants manualmente"),
    ACESSAR_BACKOFFICE("ADMIN", "Acesso à interface administrativa"),

    // ------------------------ SEGURANÇA E SESSÕES ------------------------
    ENCERRAR_SESSAO_OUTROS("SEGURANCA", "Pode encerrar sessões de outros usuários"),
    GERENCIAR_ACESSOS("SEGURANCA", "Pode configurar controle de acesso por perfil")

}
