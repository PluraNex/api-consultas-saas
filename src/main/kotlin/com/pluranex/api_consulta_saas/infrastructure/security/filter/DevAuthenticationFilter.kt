package com.pluranex.api_consulta_saas.infrastructure.security.filter

import com.pluranex.api_consulta_saas.infrastructure.security.session.provider.SessaoUsuarioProvider
import common.session.core.SessaoUsuario
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Profile("loc")
@Component
class DevAuthenticationFilter(
    private val sessaoUsuarioProvider: SessaoUsuarioProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val sessao: SessaoUsuario = sessaoUsuarioProvider.getSessao(request)
        val auth = UsernamePasswordAuthenticationToken(sessao, null, emptyList())
        SecurityContextHolder.getContext().authentication = auth
        filterChain.doFilter(request, response)
    }
}
