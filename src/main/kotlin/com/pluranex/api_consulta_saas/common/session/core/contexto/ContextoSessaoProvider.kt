package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.infrastructure.security.session.provider.SessaoUsuarioProvider
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext

/**
 * Implementação concreta de [ContextoTecnicoSessao], injetada por requisição.
 *
 * Extrai os dados da sessão atual via [SessaoUsuarioProvider], carregando:
 * - Permissões ativas
 * - Parâmetros de sistema (mock por enquanto)
 * - Plano contratado e recursos
 * - Especialidades do usuário
 * - Perfil da clínica
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class ContextoSessaoProvider(
    request: HttpServletRequest,
    sessaoUsuarioProvider: SessaoUsuarioProvider
) : ContextoTecnicoSessao() {

    private val sessao = sessaoUsuarioProvider.getSessao(request)

    override val permissoes: PermissoesAtivas = sessao.contexto.permissoes

    override val plano: PlanoContratado = sessao.contexto.plano

    override val especialidadesUsuario: List<EspecialidadeAtuacaoUsuario> = sessao.contexto.especialidadesUsuario

    override val perfilClinica: PerfilClinica = sessao.contexto.perfilClinica
}
