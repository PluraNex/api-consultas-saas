package com.pluranex.api_consulta_saas.common.types.profissional

import java.io.Serializable
import java.util.regex.Pattern

/**
 * Value Object que representa o número de registro de um profissional em seu conselho de classe.
 *
 * Esse valor pode representar CRM, CRP, CREFITO, CREF, COREN, entre outros, e geralmente possui
 * uma estrutura semi-flexível com letras, números e separadores.
 *
 * ### Responsabilidades:
 * - Garantir que o valor não esteja vazio ou malformado.
 * - Padronizar a representação textual.
 * - Fornecer ponto central para futura validação específica por conselho.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val registro = RegistroProfissional("CRP 06/12345")
 * println(registro) // CRP 06/12345
 * ```
 *
 * @property value Valor bruto do registro (com ou sem formatação).
 * @throws IllegalArgumentException se o valor for inválido.
 */
@JvmInline
value class RegistroProfissional(val value: String) : Serializable {

    init {
        require(isValid(value)) { "Registro profissional inválido: '$value'" }
    }

    companion object {
        private val REGISTRO_REGEX = Pattern.compile("^[A-Z]{2,5}\\s?[-/]?\\d{2,10}.*$")

        /**
         * Verifica se o registro profissional é minimamente válido.
         *
         * Essa validação básica aceita padrões como:
         * - CRP 06/12345
         * - CRM-SP 123456
         * - COREN12345
         *
         * ### Regras aplicadas:
         * - Começa com 2 a 5 letras maiúsculas.
         * - Pode conter espaços, barras, hífens.
         * - Seguido de 2 a 10 dígitos.
         *
         * @param registro Valor informado pelo usuário.
         * @return true se for aceito, false caso contrário.
         */
        fun isValid(registro: String): Boolean {
            val cleaned = registro.trim()
            return cleaned.length in 5..30 && REGISTRO_REGEX.matcher(cleaned).matches()
        }
    }

    /**
     * Retorna o valor limpo do registro profissional, sem formatação extra.
     */
    override fun toString(): String = value.trim()
}
