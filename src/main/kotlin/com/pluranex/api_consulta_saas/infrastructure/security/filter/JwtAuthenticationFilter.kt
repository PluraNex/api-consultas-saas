package com.pluranex.api_consulta_saas.infrastructure.security.filter

import com.pluranex.api_consulta_saas.infrastructure.security.session.token.JwtTokenProvider
import common.session.core.SessaoUsuario
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
@Profile("!loc")
class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = extractToken(request)

        if (token != null) {
            try {
                val sessaoUsuario: SessaoUsuario = jwtTokenProvider.getAuthentication(token)
                val authentication = UsernamePasswordAuthenticationToken(sessaoUsuario, null, emptyList())

                SecurityContextHolder.getContext().authentication = authentication
            } catch (e: Exception) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido ou expirado")
                return
            }
        }

        filterChain.doFilter(request, response)
    }

    private fun extractToken(request: HttpServletRequest): String? {
        val header = request.getHeader("Authorization")
        return if (!header.isNullOrEmpty() && header.startsWith("Bearer ")) {
            header.substring(7)
        } else null
    }
}
