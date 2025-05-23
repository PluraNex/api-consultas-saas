package com.pluranex.api_consulta_saas.common.annotations

import com.pluranex.api_consulta_saas.common.session.enums.Permissao

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequirePermission(val value: Permissao)
