package com.pluranex.api_consulta_saas.infrastructure.security.session.provider

import com.auth0.jwt.JWT
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.ObjectMapper
import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.exceptions.AuthException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("!loc")
class JwtSessaoUsuarioProviderImpl(
    private val objectMapper: ObjectMapper,
    @Value("\${security.jwt.secret}") private val secret: String,
    @Value("\${security.jwt.issuer}") private val issuer: String
) : SessaoUsuarioProvider {

    override fun getSessao(request: HttpServletRequest): SessaoUsuario {
        val token = request.getHeader("Authorization")
            ?.takeIf { it.startsWith("Bearer ") }
            ?.substring(7)
            ?: throw AuthException(AuthException.AuthExceptionType.TOKEN_AUSENTE)

        return try {
            val jwt = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(issuer)
                .build()
                .verify(token)

            val json = jwt.getClaim("sessao").asString()
            objectMapper.readValue(json, SessaoUsuario::class.java)
        } catch (ex: JWTVerificationException) {
            throw AuthException(AuthException.AuthExceptionType.TOKEN_INVALIDO, cause = ex)
        } catch (ex: Exception) {
            throw AuthException(AuthException.AuthExceptionType.ERRO_DESSERIALIZAR_SESSAO, cause = ex)
        }
    }
}
