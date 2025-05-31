package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import org.springframework.stereotype.Component

/**
 * Facade de acesso ao [ContextoSessaoProvider], expondo operações de uso frequente
 * em validações de negócio e regras de autorização baseadas na sessão atual.
 */
@Component
class ContextoSessaoResolver(
    private val contextoSessao: ContextoSessaoProvider
) {

    // ---------------------
    // 🏥 Perfil da clínica
    // ---------------------

    fun obterPerfilClinica(): PerfilClinica = contextoSessao.perfilClinica

    fun isDesenvolvimentoInfantil(): Boolean =
        contextoSessao.perfilClinica == PerfilClinica.DESENVOLVIMENTO_INFANTIL

    fun isMultidisciplinar(): Boolean =
        contextoSessao.perfilClinica == PerfilClinica.MULTIDISCIPLINAR

    fun isClinicaGeral(): Boolean =
        contextoSessao.perfilClinica == PerfilClinica.CLINICA_GERAL

    fun isClinicaIndefinida(): Boolean =
        contextoSessao.perfilClinica == PerfilClinica.INDEFINIDO

    // ---------------------
    // 🔐 Permissões
    // ---------------------

    fun possuiPermissao(permissao: Permissao): Boolean =
        contextoSessao.permissoes.contem(permissao)

    fun possuiTodasPermissoes(vararg permissoes: Permissao): Boolean =
        contextoSessao.permissoes.contemTodas(*permissoes)

    fun possuiAlgumaPermissao(vararg permissoes: Permissao): Boolean =
        contextoSessao.permissoes.contemAlguma(*permissoes)

    fun isAdmin(): Boolean =
        contextoSessao.permissoes.isAdmin()

    fun isGestorClinica(): Boolean =
        contextoSessao.permissoes.isGestorClinica()

    // ---------------------
    // 📦 Tipo de plano
    // ---------------------

    fun isPlanoTrial(): Boolean =
        contextoSessao.tipoPlano == PlanoTenant.TRIAL

    fun isPlanoPro(): Boolean =
        contextoSessao.tipoPlano == PlanoTenant.PRO

    fun isPlanoEnterprise(): Boolean =
        contextoSessao.tipoPlano == PlanoTenant.ENTERPRISE

    // ---------------------
    // ⚙️ Recursos contratados
    // ---------------------

    fun possuiLicencasDisponiveis(): Boolean =
        contextoSessao.possuiLicencasDisponiveis

    fun possuiIA(): Boolean =
        contextoSessao.possuiIA

    fun possuiTokensIaDisponiveis(): Boolean =
        contextoSessao.possuiTokensIaDisponiveis

    fun possuiVideochamada(): Boolean =
        contextoSessao.possuiVideochamadaDisponivel
}
