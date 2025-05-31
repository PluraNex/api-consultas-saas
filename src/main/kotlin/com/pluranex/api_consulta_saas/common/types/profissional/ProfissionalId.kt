package com.pluranex.api_consulta_saas.common.types.profissional

import java.util.UUID

/**
 * Value Object que representa o identificador único e imutável de um profissional da clínica.
 *
 * Utiliza UUID para garantir unicidade global e segurança em ambientes distribuídos.
 * Segue o padrão utilizado em [UserId] e [TenantId], promovendo consistência e legibilidade no domínio.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val profissionalId = ProfissionalId.random()
 * println(profissionalId) // ex: "f36cb61b-04f3-4fc7-9a3e-1bbf2e774d7d"
 * ```
 *
 * @property value UUID que representa a identidade do profissional.
 */
@JvmInline
value class ProfissionalId(val value: UUID) {

    override fun toString(): String = value.toString()

    companion object {
        /**
         * Gera um novo UUID aleatório para [ProfissionalId].
         */
        fun random(): ProfissionalId = ProfissionalId(UUID.randomUUID())

        /**
         * Constrói um [ProfissionalId] a partir de uma string UUID válida.
         *
         * @throws IllegalArgumentException se a string não for um UUID válido.
         */
        fun fromString(id: String): ProfissionalId = ProfissionalId(UUID.fromString(id))
    }
}
