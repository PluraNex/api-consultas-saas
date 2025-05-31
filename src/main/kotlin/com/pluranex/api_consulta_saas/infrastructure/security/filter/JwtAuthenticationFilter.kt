package com.pluranex.api_consulta_saas.infrastructure.security.filter

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.exceptions.AuthException
import com.pluranex.api_consulta_saas.infrastructure.security.session.token.JwtTokenProvider
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
        try {
            val token = extractTokenOrThrow(request)
            val sessaoUsuario: SessaoUsuario = jwtTokenProvider.getAuthentication(token)

            val authentication = UsernamePasswordAuthenticationToken(sessaoUsuario, null, emptyList())
            SecurityContextHolder.getContext().authentication = authentication
        } catch (ex: AuthException) {
            // Exceções semânticas lançadas de propósito, serão capturadas pelo GlobalExceptionHandler
            throw ex
        } catch (ex: Exception) {
            // Qualquer outra falha não esperada será tratada como falha genérica de autenticação
            throw AuthException(AuthException.AuthExceptionType.FALHA_AUTENTICACAO, cause = ex)
        }

        filterChain.doFilter(request, response)
    }

    private fun extractTokenOrThrow(request: HttpServletRequest): String {
        return request.getHeader("Authorization")
            ?.takeIf { it.startsWith("Bearer ") }
            ?.substring(7)
            ?: throw AuthException(AuthException.AuthExceptionType.TOKEN_AUSENTE)
    }
}
