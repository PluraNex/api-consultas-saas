package com.pluranex.api_consulta_saas.common.types.contato

import java.util.regex.Pattern

/**
 * Value object que representa um endereço de e-mail válido.
 *
 * Utiliza uma expressão regular simplificada, baseada na RFC 5322, para garantir
 * a integridade do dado e prevenir instâncias inválidas na camada de domínio.
 *
 * Esta classe faz parte do núcleo de validação e identidade do sistema,
 * respeitando os princípios de design orientado a objetos e arquitetura limpa.
 *
 * ### Responsabilidades:
 * - Garantir a validade do e-mail no momento da criação.
 * - Padronizar a representação de um e-mail em objetos de valor (value objects).
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val email = Email("usuario@dominio.com")
 * println(email) // usuario@dominio.com
 * ```
 *
 * @property value Endereço de e-mail validado.
 * @throws IllegalArgumentException se o valor informado não for um e-mail válido.
 */
@JvmInline
value class Email(val value: String) {

    init {
        require(isValid(value)) { "E-mail inválido: $value" }
    }

    companion object {
        /**
         * Expressão regular simplificada para validação de e-mails.
         *
         * Esta expressão cobre a maioria dos formatos utilizados em sistemas reais,
         * sem complicações excessivas da RFC completa.
         *
         * - Aceita letras, números, pontos, hífens e underscores.
         * - Domínio com um ou mais subdomínios e TLD com ao menos 2 letras.
         *
         * ⚠️ Atenção: não cobre todos os edge cases da RFC 5322.
         */
        private val EMAIL_REGEX = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE
        )

        /**
         * Valida se a string informada é um e-mail válido.
         *
         * @param email E-mail a ser verificado (com ou sem caixa alta).
         * @return `true` se for válido, `false` caso contrário.
         */
        fun isValid(email: String): Boolean {
            return EMAIL_REGEX.matcher(email).matches()
        }
    }

    /**
     * Retorna o e-mail como string formatada (valor original).
     *
     * @return E-mail em formato texto.
     */
    override fun toString(): String = value
}