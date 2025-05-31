package com.pluranex.api_consulta_saas.domain.sessao

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario

/**
 * Representa um usuário autenticado no sistema, sob determinado tenant.
 *
 * Essa classe é usada no domínio para tomar decisões baseadas em quem está
 * realizando a ação e sob qual escopo organizacional.
 */
data class UsuarioAutenticado(
    val userId: UserId,
    val tenantId: TenantId,
    val perfil: PerfilUsuario,
    val idMedico: String? = null,
    val idPaciente: String? = null
) {

    /** Verifica se o usuário possui perfil administrativo (admin ou master). */
    fun isAdmin(): Boolean = perfil.isAdmin

    /** Verifica se o usuário é o superusuário do sistema. */
    fun isMaster(): Boolean = perfil.isMaster

    /** Verifica se o usuário é um profissional de saúde. */
    fun isMedico(): Boolean = perfil == PerfilUsuario.MEDICO

    /** Verifica se o usuário é paciente. */
    fun isPaciente(): Boolean = perfil == PerfilUsuario.PACIENTE
}
