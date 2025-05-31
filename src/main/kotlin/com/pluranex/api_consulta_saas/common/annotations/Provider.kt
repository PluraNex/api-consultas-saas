package com.pluranex.api_consulta_saas.common.annotations

import org.springframework.stereotype.Component

/**
 * Indica que a classe é um *Provider*, ou seja, um componente que fornece
 * lógica utilitária reutilizável, como acesso contextual, configuração,
 * resolução de políticas, ou adaptadores internos não pertencentes ao domínio.
 *
 * Semântica diferente de @Service (regras de aplicação) e @Validator (regras de domínio).
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Provider
