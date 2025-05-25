package com.pluranex.api_consulta_saas.common.types.identidade

import java.util.regex.Pattern

/**
 * Representa um CPF (Cadastro de Pessoa Física) no formato de [value class], garantindo que o valor
 * seja validado e formatado corretamente na criação da instância.
 *
 * ### Exemplo de uso:
 * ```
 * val cpf = Cpf("12345678909")
 * println(cpf) // 123.456.789-09
 * ```
 *
 * @property value O valor bruto do CPF (apenas dígitos).
 * @throws IllegalArgumentException se o valor não for um CPF válido.
 */
@JvmInline
value class Cpf(val value: String) {

    init {
        require(isValid(value)) { "CPF inválido: $value" }
    }

    companion object {
        /**
         * Expressão regular para verificar se o CPF contém exatamente 11 dígitos.
         */
        private val CPF_REGEX = Pattern.compile("^\\d{11}$")

        /**
         * Valida se um CPF é estruturalmente correto.
         *
         * - Remove quaisquer caracteres não numéricos.
         * - Verifica se tem exatamente 11 dígitos.
         * - Rejeita sequências com todos os dígitos iguais.
         * - Valida os dois dígitos verificadores.
         *
         * @param cpf CPF a ser validado, com ou sem formatação.
         * @return `true` se for válido, `false` caso contrário.
         */
        fun isValid(cpf: String): Boolean {
            val normalized = cpf.filter { it.isDigit() }
            if (!CPF_REGEX.matcher(normalized).matches()) return false
            if (normalized.toCharArray().distinct().size == 1) return false
            return checkDigits(normalized)
        }

        /**
         * Verifica os dígitos verificadores do CPF, conforme o algoritmo oficial.
         */
        private fun checkDigits(cpf: String): Boolean {
            fun calcDigit(cpf: String, weights: IntRange): Int {
                val sum = weights.mapIndexed { i, w -> cpf[i].digitToInt() * w }.sum()
                val mod = sum % 11
                return if (mod < 2) 0 else 11 - mod
            }

            val digit1 = calcDigit(cpf, (10 downTo 2) as IntRange)
            val digit2 = calcDigit(cpf + digit1, (11 downTo 2) as IntRange)

            return cpf.endsWith("$digit1$digit2")
        }
    }

    /**
     * Retorna o CPF formatado no padrão `XXX.XXX.XXX-XX`.
     */
    override fun toString(): String {
        val digits = value.filter { it.isDigit() }
        return "${digits.substring(0, 3)}.${digits.substring(3, 6)}.${digits.substring(6, 9)}-${digits.substring(9, 11)}"
    }
}