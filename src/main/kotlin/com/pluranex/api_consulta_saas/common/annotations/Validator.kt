package com.pluranex.api_consulta_saas.common.annotations

import org.springframework.stereotype.Component
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS

/**
 * Anotação semântica para marcar validadores de domínio.
 * Pode ser usada em substituição a [Component] em classes de validação.
 */
@Target(CLASS)
@Retention(RUNTIME)
@MustBeDocumented
@Component
annotation class Validator
