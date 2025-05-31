package com.pluranex.api_consulta_saas.domain.plano.types

import com.pluranex.api_consulta_saas.common.types.recurso.RecursosDisponiveis
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Value Object que representa o plano contratado por um tenant.
 *
 * Encapsula o tipo de plano ([PlanoTenant]) e os recursos disponíveis,
 * garantindo coesão, imutabilidade e centralização das regras de provisionamento.
 *
 * Deve ser instanciado por meio do método de fábrica [doPlano], que aplica
 * as configurações padrão de recursos do plano.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val plano = PlanoContratado.doPlano(PlanoTenant.PRO)
 * println(plano.tipo) // PRO
 * println(plano.recursos.temVideochamadaDisponivel()) // true/false
 * ```
 *
 * @property tipo Tipo do plano contratado (ex: TRIAL, PRO, ENTERPRISE)
 * @property recursos Acesso semântico aos recursos contratados
 */
data class PlanoContratado(
    val tipo: PlanoTenant,
    private val recursosContratados: RecursosContratados
) {
    val recursos: RecursosDisponiveis = RecursosDisponiveis(recursosContratados)

    companion object {

        /**
         * Cria uma instância de [PlanoContratado] com os recursos padrão para o plano.
         *
         * @param plano Tipo de plano desejado.
         * @return Instância de [PlanoContratado]
         */
        fun doPlano(plano: PlanoTenant): PlanoContratado =
            PlanoContratado(plano, plano.recursosPadrao())
    }
}
