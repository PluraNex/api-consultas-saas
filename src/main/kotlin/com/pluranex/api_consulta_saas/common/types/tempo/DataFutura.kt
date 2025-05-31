package com.pluranex.api_consulta_saas.common.types.tempo

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Value Object que representa uma data futura válida.
 *
 * Garante que a data fornecida esteja sempre no futuro em relação à data/hora atual
 * (isto é, posterior ao momento de criação da instância).
 *
 * ### Responsabilidades:
 * - Evitar uso de datas passadas para agendamentos, vencimentos ou ativações.
 * - Fornecer semântica clara para validações de regras temporais no domínio.
 * - Promover segurança e clareza na manipulação de datas futuras.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val data = DataFutura(LocalDate.now().plusDays(1))
 * println(data) // 2025-06-01
 * ```
 *
 * @property value A data futura garantida (não pode ser hoje nem no passado).
 * @throws IllegalArgumentException se a data for anterior ou igual a hoje.
 */
@JvmInline
value class DataFutura(val value: LocalDate) : Serializable {

    init {
        require(value.isAfter(LocalDate.now())) {
            "A data deve ser futura (posterior a hoje): recebida $value"
        }
    }

    override fun toString(): String = value.toString()

    companion object {
        /**
         * Cria uma instância a partir de um [LocalDateTime], convertendo para [LocalDate].
         */
        fun fromDateTime(dateTime: LocalDateTime): DataFutura =
            DataFutura(dateTime.toLocalDate())
    }
}
