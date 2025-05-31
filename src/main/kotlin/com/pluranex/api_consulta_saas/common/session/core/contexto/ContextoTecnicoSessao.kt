package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.common.types.recurso.RecursosDisponiveis

/**
 * Representa o contexto técnico-operacional da sessão atual do usuário.
 *
 * Inclui permissões, especialidades, plano contratado e perfil da clínica.
 * Serve como base para decisões de autorização, ativação de recursos e regras de negócio.
 */
abstract class ContextoTecnicoSessao {

    abstract val permissoes: PermissoesAtivas
    abstract val plano: PlanoContratado
    abstract val especialidadesUsuario: List<EspecialidadeAtuacaoUsuario>
    abstract val perfilClinica: PerfilClinica

    /**
     * Wrapper com recursos contratados do plano atual, com métodos utilitários.
     */
    val recursos: RecursosDisponiveis get() = plano.recursos

    /**
     * Tipo de plano contratado (TRIAL, PRO, ENTERPRISE...).
     */
    val tipoPlano get() = plano.tipo

    // Extensões inline úteis
    val possuiLicencasDisponiveis: Boolean get() = recursos.possuiLicencasDisponiveis()
    val possuiArmazenamentoDisponivel: Boolean get() = recursos.possuiArmazenamentoDisponivel()
    val possuiIA: Boolean get() = recursos.possuiIA()
    val possuiTokensIaDisponiveis: Boolean get() = recursos.possuiTokensIaDisponiveis()
    val possuiVideochamadaDisponivel: Boolean get() = recursos.temVideochamadaDisponivel()
}
