package com.pluranex.api_consulta_saas.common.types.identidade

import java.io.Serializable
import java.util.regex.Pattern

/**
 * Value object que representa um CNPJ (Cadastro Nacional da Pessoa Jurídica) válido.
 *
 * Realiza validação estrutural baseada no algoritmo oficial da Receita Federal e
 * formata automaticamente a saída. Este objeto garante integridade e imutabilidade
 * na camada de domínio, promovendo clareza semântica e segurança.
 *
 * ### Responsabilidades:
 * - Validar CNPJs no momento da criação.
 * - Padronizar o uso de CNPJs como value objects reutilizáveis.
 * - Impedir instâncias inválidas em fluxos de negócio e persistência.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val cnpj = Cnpj("12345678000195")
 * println(cnpj) // 12.345.678/0001-95
 * ```
 *
 * @property value O valor bruto do CNPJ (somente dígitos).
 * @throws IllegalArgumentException se o valor não for um CNPJ válido.
 */
@JvmInline
value class Cnpj(val value: String) : Serializable {

    init {
        require(isValid(value)) { "CNPJ inválido: $value" }
    }

    companion object {
        private val CNPJ_REGEX = Pattern.compile("^\\d{14}$")

        /**
         * Verifica se um CNPJ fornecido é estruturalmente válido.
         *
         * - Remove caracteres não numéricos.
         * - Verifica se contém 14 dígitos.
         * - Rejeita sequências com todos os dígitos iguais.
         * - Valida os dois dígitos verificadores.
         *
         * @param cnpj CNPJ no formato livre ou com formatação.
         * @return `true` se for válido, `false` caso contrário.
         */
        fun isValid(cnpj: String): Boolean {
            val digits = cnpj.filter { it.isDigit() }
            if (!CNPJ_REGEX.matcher(digits).matches()) return false
            if (digits.all { it == digits[0] }) return false

            fun calcDigit(base: String, weights: List<Int>): Int {
                val sum = base.mapIndexed { i, c -> c.digitToInt() * weights[i] }.sum()
                val mod = sum % 11
                return if (mod < 2) 0 else 11 - mod
            }

            val base = digits.substring(0, 12)
            val digit1 = calcDigit(base, listOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2))
            val digit2 = calcDigit(base + digit1, listOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2))

            return digits.endsWith("$digit1$digit2")
        }
    }

    /**
     * Retorna o CNPJ formatado no padrão `XX.XXX.XXX/XXXX-XX`.
     *
     * @return String com a máscara oficial aplicada.
     */
    override fun toString(): String {
        val d = value.filter { it.isDigit() }
        return "${d.substring(0, 2)}.${d.substring(2, 5)}.${d.substring(5, 8)}/${d.substring(8, 12)}-${d.substring(12)}"
    }
}
