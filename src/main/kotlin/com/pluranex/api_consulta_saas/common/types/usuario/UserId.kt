package com.pluranex.api_consulta_saas.common.types.usuario

import java.util.UUID

/**
 * Value Object que representa de forma única e imutável o identificador de um usuário no sistema.
 *
 * Utiliza o padrão [UUID] para garantir unicidade global entre diferentes tenants e ambientes,
 * sendo ideal para sistemas distribuídos, escaláveis e seguros.
 *
 * ### Responsabilidades:
 * - Garantir a identidade única do usuário.
 * - Proteger contra enumeração de IDs sequenciais.
 * - Evitar colisões entre ambientes ou tenants.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val id = UserId.random()
 * println(id) // b64e39b1-99e7-4c7d-bd09-9eb98429b370
 * ```
 *
 * @property value Identificador único baseado em UUID (ex: b64e39b1-99e7-4c7d-bd09-9eb98429b370)
 */
@JvmInline
value class UserId(val value: UUID) {

    /**
     * Representação textual do UUID como string padrão (canonical format).
     */
    override fun toString(): String = value.toString()

    companion object {
        /**
         * Gera um novo identificador aleatório e único para usuários.
         */
        fun random(): UserId = UserId(UUID.randomUUID())

        /**
         * Constrói um [UserId] a partir de uma string UUID válida.
         *
         * @throws IllegalArgumentException se a string não for um UUID válido.
         */
        fun fromString(id: String): UserId = UserId(UUID.fromString(id))
    }
}
