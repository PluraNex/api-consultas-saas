package com.pluranex.api_consulta_saas.domain.plano.types

import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.plano.PlanoTenantRecursos
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Value Object que representa o plano contratado por um tenant.
 *
 * Encapsula tanto o tipo do plano ([PlanoTenant]) quanto os [RecursosContratados]
 * associados, garantindo coesão, imutabilidade e centralização das regras de provisionamento.
 *
 * Deve ser criado a partir de um [PlanoTenant] por meio do método de fábrica [doPlano],
 * que garante a aplicação correta da configuração padrão do plano.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val plano = PlanoContratado.doPlano(PlanoTenant.PRO)
 * println(plano.tipo) // PRO
 * println(plano.recursos.envioEmails.restante())
 * ```
 *
 * @property tipo Tipo de plano contratado (ex: TRIAL, PRO, ENTERPRISE).
 * @property recursos Conjunto de limites e capacidades fornecidos por esse plano.
 */
data class PlanoContratado(
    val tipo: PlanoTenant,
    val recursos: RecursosContratados
) {
    companion object {
        /**
         * Cria um `PlanoContratado` com os recursos padrão para o [PlanoTenant] informado.
         *
         * @param plano Tipo de plano desejado.
         * @return Instância de [PlanoContratado] com configuração padrão para o plano.
         */
        fun doPlano(plano: PlanoTenant): PlanoContratado =
            PlanoContratado(plano, plano.recursosPadrao())
    }
}
