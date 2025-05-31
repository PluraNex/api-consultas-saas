package com.pluranex.api_consulta_saas.application.sessao

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.common.session.mapper.toUsuarioAutenticado
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessaoProvider
import com.pluranex.api_consulta_saas.domain.sessao.SessaoContextoDomain
import com.pluranex.api_consulta_saas.domain.sessao.SessaoService
import com.pluranex.api_consulta_saas.domain.sessao.UsuarioAutenticado
import com.pluranex.api_consulta_saas.infrastructure.security.session.provider.SessaoUsuarioProvider
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class SessaoServiceImpl(
    private val request: HttpServletRequest,
    private val sessaoUsuarioProvider: SessaoUsuarioProvider,
    private val contextoSessaoProvider: ContextoSessaoProvider
) : SessaoService {

    override fun obterSessaoUsuario(): SessaoUsuario {
        return sessaoUsuarioProvider.getSessao(request)
    }

    override fun obterUsuarioAutenticado(): UsuarioAutenticado {
        return obterSessaoUsuario().toUsuarioAutenticado()
    }

    override fun obterContextoSessao(): SessaoContextoDomain {
        return SessaoContextoDomain(
            usuario = obterUsuarioAutenticado(),
            contexto = contextoSessaoProvider
        )
    }
}
