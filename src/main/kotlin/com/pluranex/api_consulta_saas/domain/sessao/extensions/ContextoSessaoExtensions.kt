package com.pluranex.api_consulta_saas.domain.sessao.extensions

import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.recurso.RecursosDisponiveis
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.sessao.SessaoContextoDomain

/**
 * Extensões utilitárias para facilitar o uso do [SessaoContextoDomain]
 * em regras de negócio, validações e verificações de autorização.
 *
 * Centraliza a lógica comum de decisão baseada no contexto do usuário autenticado.
 */

// -------------------------
// 🔐 Permissões
// -------------------------

/**
 * Verifica se a sessão possui uma [Permissao] específica.
 */
fun SessaoContextoDomain.possuiPermissao(permissao: Permissao): Boolean =
    contexto.permissoes.contem(permissao)

/**
 * Verifica se a sessão possui todas as permissões especificadas.
 */
fun SessaoContextoDomain.possuiTodasPermissoes(vararg permissoesDesejadas: Permissao): Boolean =
    contexto.permissoes.contemTodas(*permissoesDesejadas)

/**
 * Verifica se a sessão possui ao menos uma das permissões especificadas.
 */
fun SessaoContextoDomain.possuiAlgumaPermissao(vararg permissoesDesejadas: Permissao): Boolean =
    contexto.permissoes.contemAlguma(*permissoesDesejadas)

/**
 * Verifica se a sessão possui perfil administrativo no domínio ou por permissão ativa.
 */
fun SessaoContextoDomain.isAdmin(): Boolean =
    contexto.permissoes.isAdmin() || usuario.isAdmin()

/**
 * Verifica se a sessão pertence a um gestor de clínica.
 */
fun SessaoContextoDomain.isGestorClinica(): Boolean =
    contexto.permissoes.isGestorClinica()

// -------------------------
// 📦 Plano e Recursos
// -------------------------

/**
 * Acesso direto aos recursos contratados pelo plano atual.
 */
val SessaoContextoDomain.recursos: RecursosDisponiveis
    get() = RecursosDisponiveis(contexto.recursos)

/**
 * Verifica se o plano contratado é do tipo Trial.
 */
fun SessaoContextoDomain.isPlanoTrial(): Boolean =
    contexto.tipoPlano == PlanoTenant.TRIAL

/**
 * Verifica se o plano contratado é do tipo PRO.
 */
fun SessaoContextoDomain.isPlanoPro(): Boolean =
    contexto.tipoPlano == PlanoTenant.PRO

/**
 * Verifica se o plano contratado é do tipo Enterprise.
 */
fun SessaoContextoDomain.isPlanoEnterprise(): Boolean =
    contexto.tipoPlano == PlanoTenant.ENTERPRISE

// -------------------------
// 🩺 Especialidades do Usuário
// -------------------------

/**
 * Verifica se o usuário possui uma especialidade clínica específica.
 */
fun SessaoContextoDomain.possuiEspecialidade(especialidade: EspecialidadeAtuacaoUsuario): Boolean =
    contexto.especialidadesUsuario.contains(especialidade)

/**
 * Verifica se o usuário atua com pediatria.
 */
fun SessaoContextoDomain.atuaEmPediatria(): Boolean =
    EspecialidadeAtuacaoUsuario.PEDIATRIA in contexto.especialidadesUsuario

/**
 * Verifica se o usuário possui múltiplas especialidades clínicas.
 */
fun SessaoContextoDomain.temMultiespecialidades(): Boolean =
    contexto.especialidadesUsuario.size > 1

/**
 * Verifica se o usuário possui ao menos uma especialidade clínica.
 */
fun SessaoContextoDomain.possuiEspecialidades(): Boolean =
    contexto.especialidadesUsuario.isNotEmpty()

// -------------------------
// 🏥 Perfil da Clínica
// -------------------------

/**
 * Verifica se a clínica possui perfil de desenvolvimento infantil.
 */
fun SessaoContextoDomain.isClinicaDesenvolvimentoInfantil(): Boolean =
    contexto.perfilClinica == PerfilClinica.DESENVOLVIMENTO_INFANTIL

/**
 * Verifica se a clínica possui perfil multidisciplinar.
 */
fun SessaoContextoDomain.isClinicaMultidisciplinar(): Boolean =
    contexto.perfilClinica == PerfilClinica.MULTIDISCIPLINAR

/**
 * Verifica se a clínica possui perfil genérico (clínica geral ou multidisciplinar).
 */
fun SessaoContextoDomain.isClinicaGenerica(): Boolean =
    contexto.perfilClinica in listOf(
        PerfilClinica.CLINICA_GERAL,
        PerfilClinica.MULTIDISCIPLINAR
    )

/**
 * Verifica se a clínica possui perfil geriátrico.
 */
fun SessaoContextoDomain.isClinicaGeriatrica(): Boolean =
    contexto.perfilClinica == PerfilClinica.GERIATRIA

/**
 * Verifica se a clínica possui perfil cardiológico.
 */
fun SessaoContextoDomain.isClinicaCardiologica(): Boolean =
    contexto.perfilClinica == PerfilClinica.CARDIOLOGIA

/**
 * Verifica se o perfil da clínica é indefinido (fallback).
 */
fun SessaoContextoDomain.isClinicaIndefinida(): Boolean =
    contexto.perfilClinica == PerfilClinica.INDEFINIDO
