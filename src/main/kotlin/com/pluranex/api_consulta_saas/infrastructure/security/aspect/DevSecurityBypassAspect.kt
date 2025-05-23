package com.pluranex.api_consulta_saas.infrastructure.security.aspect

import com.pluranex.api_consulta_saas.common.annotations.RequirePermission
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Aspect
@Component
@Profile("loc")
class DevSecurityBypassAspect {

    @Before("@annotation(requirePermission)")
    fun bypassPermission(requirePermission: RequirePermission) {
        // Em modo dev, qualquer permissão é aceita — nada a fazer aqui.
    }
}
