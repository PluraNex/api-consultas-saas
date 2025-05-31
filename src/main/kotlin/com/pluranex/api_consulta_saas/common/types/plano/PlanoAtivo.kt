package com.pluranex.api_consulta_saas.common.types.plano

import com.pluranex.api_consulta_saas.domain.enums.plano.TipoPlano
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Wrapper de valor que encapsula o plano contratado e oferece
 * métodos utilitários para validações e decisões de negócio.
 *
 * ### Responsabilidades:
 * - Informar se o plano é trial, gratuito ou pago
 * - Expor os recursos contratados
 * - Expor o tipo do plano de forma segura
 */
@JvmInline
value class PlanoAtivo(val plano: PlanoContratado) {

    /** Tipo do plano contratado (ex: TRIAL, PRO, FREE, ENTERPRISE) */
    val tipo: TipoPlano get() = plano.tipo

    /** Recursos disponíveis conforme o plano */
    val recursos: RecursosContratados get() = plano.recursos

    /** Verifica se o plano é do tipo TRIAL */
    fun isTrial(): Boolean = tipo == TipoPlano.TRIAL

    /** Verifica se o plano é gratuito */
    fun isGratuito(): Boolean = tipo == TipoPlano.FREE

    /** Verifica se o plano é um plano pago (não é trial nem gratuito) */
    fun isPago(): Boolean = !isTrial() && !isGratuito()

    /** Verifica se é o plano PRO */
    fun isPro(): Boolean = tipo == TipoPlano.PRO

    /** Verifica se é o plano ENTERPRISE */
    fun isEnterprise(): Boolean = tipo == TipoPlano.ENTERPRISE
}
