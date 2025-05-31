package com.pluranex.api_consulta_saas.domain.usuario.builder

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoTecnicoSessao
import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.parametro.ParametrosSistema
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado

/**
 * Builder para construção fluida e segura da [SessaoUsuario].
 *
 * Permite configurar passo a passo os elementos necessários para uma sessão
 * de usuário, garantindo imutabilidade e clareza.
 *
 * ### Exemplo:
 * ```kotlin
 * val sessao = SessaoUsuarioBuilder(userId, tenantId, perfil)
 *     .comPlano(plano)
 *     .comPerfilClinica(perfilClinica)
 *     .comEspecialidades(especialidades)
 *     .build()
 * ```
 */
class SessaoUsuarioBuilder(
    private val userId: UserId,
    private val tenantId: TenantId,
    private val perfil: PerfilUsuario
) {
    private var permissoes: PermissoesAtivas = PermissoesAtivas.vazio
    private var parametros: ParametrosSistema = ParametrosSistema.vazio()
    private lateinit var plano: PlanoContratado
    private lateinit var perfilClinica: PerfilClinica
    private var especialidades: List<EspecialidadeAtuacaoUsuario> = emptyList()

    fun comPermissoes(permissoes: PermissoesAtivas) = apply { this.permissoes = permissoes }
    fun comParametros(parametros: ParametrosSistema) = apply { this.parametros = parametros }
    fun comPlano(plano: PlanoContratado) = apply { this.plano = plano }
    fun comPerfilClinica(perfilClinica: PerfilClinica) = apply { this.perfilClinica = perfilClinica }
    fun comEspecialidades(especialidades: List<EspecialidadeAtuacaoUsuario>) = apply { this.especialidades = especialidades }

    fun build(): SessaoUsuario {
        require(::plano.isInitialized) { "PlanoContratado deve ser definido." }
        require(::perfilClinica.isInitialized) { "Perfil da clínica deve ser definido." }

        val contexto = ContextoTecnicoSessao(
            permissoes = permissoes,
            parametros = parametros,
            plano = plano,
            especialidades = especialidades,
            perfilClinica = perfilClinica
        )

        return SessaoUsuario(
            userId = userId,
            tenantId = tenantId,
            perfil = perfil,
            contexto = contexto
        )
    }
}
