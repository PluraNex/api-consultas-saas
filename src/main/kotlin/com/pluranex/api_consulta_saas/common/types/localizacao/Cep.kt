package com.pluranex.api_consulta_saas.common.types.localizacao

import java.io.Serializable

/**
 * Value Object que representa um CEP (Código de Endereçamento Postal) válido no Brasil.
 *
 * Aceita formatos com ou sem hífen (`xxxxx-xxx` ou `xxxxxxxx`) e realiza validação básica.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val cep = Cep("12345-678")
 * println(cep) // 12345-678
 * ```
 *
 * @property value Valor do CEP validado.
 * @throws IllegalArgumentException Se o valor não for um CEP válido.
 */
@JvmInline
value class Cep(val value: String) : Serializable {

    init {
        require(isValid(value)) { "CEP inválido: $value" }
    }

    companion object {
        private val CEP_REGEX = Regex("^\\d{5}-?\\d{3}$")

        /**
         * Verifica se o valor fornecido é um CEP válido.
         *
         * @param raw String contendo o CEP (com ou sem hífen).
         * @return `true` se o CEP for válido, `false` caso contrário.
         */
        fun isValid(raw: String): Boolean = CEP_REGEX.matches(raw)
    }

    /**
     * Retorna o CEP formatado com hífen (ex: `12345-678`).
     */
    override fun toString(): String {
        val digits = value.filter { it.isDigit() }
        return "${digits.substring(0, 5)}-${digits.substring(5, 8)}"
    }
}
