package com.pluranex.api_consulta_saas.infrastructure.security.session.provider

import com.pluranex.api_consulta_saas.common.session.core.*
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessao
import com.pluranex.api_consulta_saas.common.session.enums.*
import com.pluranex.api_consulta_saas.common.types.parametro.ParametrosSistema
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas


object DevPerfilFactory {

    fun criar(header: String): PerfilUsuario = when (header) {
        "ADMIN" -> PerfilUsuario("ADMIN", OrigemPerfil.SISTEMA, true, false, null, null)
        "MASTER" -> PerfilUsuario("MASTER", OrigemPerfil.SISTEMA, true, true, null, null)
        "MEDICO" -> PerfilUsuario("MEDICO", OrigemPerfil.PROFISSIONAL_SAUDE, false, false, "42", null)
        "PACIENTE" -> PerfilUsuario("PACIENTE", OrigemPerfil.PACIENTE, false, false, null, "99")
        else -> PerfilUsuario("DEV", OrigemPerfil.SISTEMA, true, true, null, null)
    }

    fun permissoes(header: String): Set<Permissao> = when (header.uppercase()) {
        "MASTER" -> Permissao.entries.toSet()
        "ADMIN" -> setOf(
            Permissao.GERENCIAR_USUARIOS,
            Permissao.EDITAR_CONSULTA,
            Permissao.GESTAO_CLINICA
        )
        "MEDICO" -> setOf(
            Permissao.VISUALIZAR_PACIENTE,
            Permissao.CRIAR_CONSULTA,
            Permissao.FINALIZAR_CONSULTA
        )
        else -> emptySet()
    }


    fun parametros(header: String): Map<ParametroSistema, String> = mapOf(
        ParametroSistema.CANAL_PADRAO_NOTIFICACAO to "EMAIL",
        ParametroSistema.WHATSAPP_ATIVO to "true",
        ParametroSistema.EMAIL_ATIVO to "true",
        ParametroSistema.SMS_ATIVO to "true",
        ParametroSistema.IA_HABILITADA to "true"
    )

    fun contexto(header: String): ContextoSessao = ContextoSessao(
        permissoes = PermissoesAtivas(permissoes(header)),
        parametros = ParametrosSistema(parametros(header)),
        recursos = RecursosContratados.vazio(),
        especialidadesUsuario = emptyList()
    )
}
