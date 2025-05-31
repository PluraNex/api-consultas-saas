package com.pluranex.api_consulta_saas.infrastructure.security.session.token

import com.fasterxml.jackson.databind.ObjectMapper
import com.pluranex.api_consulta_saas.builders.sessao.FakeContextoTecnicoSessaoBuilder
import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.exceptions.AuthException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith

class JwtTokenProviderTest {

    private lateinit var jwtTokenProvider: JwtTokenProvider
    private val objectMapper = ObjectMapper()

    private val secret = "chave-super-secreta-para-testes-1234567890"
    private val issuer = "pluranex-api"
    private val expirationHours = 2L

    private lateinit var sessaoUsuario: SessaoUsuario

    @BeforeEach
    fun setUp() {
        jwtTokenProvider = JwtTokenProvider(objectMapper, secret, issuer, expirationHours)

        sessaoUsuario = SessaoUsuario(
            userId = UserId.fromString("123e4567-e89b-12d3-a456-426614174000"),
            tenantId = TenantId.fromString("456e4567-e89b-12d3-a456-426614174111"),
            perfil = PerfilUsuario.ADMIN,
            contexto = FakeContextoTecnicoSessaoBuilder()
                .comPermissoes(Permissao.VISUALIZAR_CONSULTA, Permissao.CRIAR_CONSULTA)
                .comPerfilClinica(PerfilClinica.PEDIATRIA)
                .build()
        )
    }

    @Test
    fun `deve gerar e validar um token JWT com sucesso`() {
        val token = jwtTokenProvider.generateToken(sessaoUsuario)

        assertNotNull(token, "Token gerado não pode ser nulo")
        assertTrue(token.isNotBlank(), "Token gerado não pode estar em branco")

        val usuarioExtraido = jwtTokenProvider.getAuthentication(token)

        assertEquals(sessaoUsuario.userId, usuarioExtraido.userId)
        assertEquals(sessaoUsuario.tenantId, usuarioExtraido.tenantId)
        assertEquals(sessaoUsuario.perfil, usuarioExtraido.perfil)
    }

    @Test
    fun `deve lançar exceção ao validar um token malformado`() {
        val tokenMalformado = "token.invalido.qualquer"

        val excecao = assertFailsWith<AuthException> {
            jwtTokenProvider.getAuthentication(tokenMalformado)
        }

        assertEquals("AUTH-001", excecao.errorCode)
        assertTrue(excecao.message!!.contains("Token inválido"), "Mensagem de erro deve indicar token inválido")
    }
}
