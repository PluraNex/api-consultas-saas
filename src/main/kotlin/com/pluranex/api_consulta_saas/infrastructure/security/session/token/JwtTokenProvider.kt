package com.pluranex.api_consulta_saas.infrastructure.security.session.token

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.fasterxml.jackson.databind.ObjectMapper
import common.session.core.SessaoUsuario
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date

@Service
class JwtTokenProvider(
    private val objectMapper: ObjectMapper,

    @Value("\${security.jwt.secret}") private val secret: String,
    @Value("\${security.jwt.issuer}") private val issuer: String,
    @Value("\${security.jwt.expiration-hours:4}") private val expirationHours: Long
) {
    private val algorithm: Algorithm = Algorithm.HMAC256(secret)

    fun generateToken(sessao: SessaoUsuario): String {
        val sessaoJson = objectMapper.writeValueAsString(sessao)

        return JWT.create()
            .withIssuer(issuer)
            .withSubject(sessao.userId)
            .withIssuedAt(Date.from(creationDate()))
            .withExpiresAt(Date.from(expirationDate()))
            .withClaim("sessao", sessaoJson)
            .sign(algorithm)
    }

    fun getAuthentication(token: String): SessaoUsuario {
        try {
            val jwt = verifier().verify(token)
            val json = jwt.getClaim("sessao").asString()
            return objectMapper.readValue(json, SessaoUsuario::class.java)
        } catch (ex: JWTVerificationException) {
            throw RuntimeException("Token JWT inválido ou expirado", ex)
        } catch (ex: Exception) {
            throw RuntimeException("Erro ao desserializar sessão", ex)
        }
    }

    private fun verifier(): JWTVerifier =
        JWT.require(algorithm).withIssuer(issuer).build()

    private fun creationDate(): Instant =
        ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant()

    private fun expirationDate(): Instant =
        ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(expirationHours).toInstant()
}