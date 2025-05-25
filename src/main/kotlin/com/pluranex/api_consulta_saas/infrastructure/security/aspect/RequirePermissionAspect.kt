package com.pluranex.api_consulta_saas.infrastructure.security.aspect

import com.pluranex.api_consulta_saas.common.annotations.RequirePermission
import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.exceptions.PermissionException
import com.pluranex.api_consulta_saas.domain.exceptions.PermissionException.PermissionExceptionType.PERMISSAO_NEGADA
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Aspect
@Component
class RequirePermissionAspect {

    @Before("@annotation(requirePermission)")
    fun checkPermission(requirePermission: RequirePermission) {
        val auth = SecurityContextHolder.getContext().authentication
        val sessao = auth.principal as? SessaoUsuario
            ?: throw PermissionException(PERMISSAO_NEGADA, "Sessão inválida ou não autenticada")

        val nomePermissao = requirePermission.value.name
        val possuiPermissao = sessao.contexto.permissoes.value.any { it.name == nomePermissao }

        if (!possuiPermissao) {
            throw PermissionException(PERMISSAO_NEGADA, "Permissão '$nomePermissao' negada ao usuário.")
        }
    }
}
