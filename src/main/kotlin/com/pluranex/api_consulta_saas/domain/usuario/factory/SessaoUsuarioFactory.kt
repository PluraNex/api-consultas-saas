package com.pluranex.api_consulta_saas.domain.usuario.factory

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario

import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.domain.usuario.builder.SessaoUsuarioBuilder

/**
 * Fábrica para construção de sessões padrão do sistema, como conta trial ou sessões simuladas.
 */
object SessaoUsuarioFactory {

    /**
     * Cria uma sessão de usuário com plano trial.
     *
     * @param userId Identificador do usuário.
     * @param tenantId Identificador do tenant.
     * @param perfil Perfil funcional do usuário (ADMIN, MÉDICO, etc).
     * @param perfilClinica Perfil da clínica (MULTIDISCIPLINAR, DESENVOLVIMENTO_INFANTIL).
     * @param especialidades Lista de especialidades associadas ao usuário.
     */
    fun criarSessaoTrial(
        userId: UserId,
        tenantId: TenantId,
        perfil: PerfilUsuario,
        perfilClinica: PerfilClinica,
        especialidades: List<EspecialidadeAtuacaoUsuario>
    ): SessaoUsuario {
        return SessaoUsuarioBuilder(userId, tenantId, perfil)
            .comPlano(PlanoContratado.doPlano(PlanoTenant.TRIAL))
            .comPerfilClinica(perfilClinica)
            .comEspecialidades(especialidades)
            .build()
    }
}
