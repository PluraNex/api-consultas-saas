package com.pluranex.api_consulta_saas.common.annotations

import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant

/**
 * Indica que o uso da funcionalidade requer um ou mais planos específicos.
 *
 * Deve ser usada em métodos (ex: endpoints REST ou services) e validada
 * por um aspecto [RequirePlanAspect].
 *
 * ### Exemplo:
 * ```kotlin
 * @RequirePlan(PlanoTenant.PRO, PlanoTenant.ENTERPRISE)
 * fun gerarRelatorioAvancado() { ... }
 * ```
 *
 * @param allowed Lista de planos permitidos para acessar a funcionalidade.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class RequirePlan(
    vararg val allowed: PlanoTenant
)
