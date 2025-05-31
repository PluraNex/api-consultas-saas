package com.pluranex.api_consulta_saas.infrastructure.security.session.provider

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("loc")
class DevSessaoUsuarioProviderImpl : SessaoUsuarioProvider {

    override fun getSessao(request: HttpServletRequest): SessaoUsuario {
        val role = request.getHeader("X-Dev-Role")?.uppercase() ?: "DEV"
        println(">>>> [DEV] DevSessaoUsuarioProviderImpl injetado com role: $role")

        return SessaoUsuario(
            userId = "dev-user",
            tenantId = "dev-tenant",
            perfil = DevPerfilFactory.criar(role),
            contexto = DevPerfilFactory.contexto(role)
        )
    }
}
