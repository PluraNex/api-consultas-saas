package com.pluranex.api_consulta_saas.common.types.tenant

import java.util.UUID

/**
 * Value Object que representa o identificador único e imutável de um tenant (cliente) na plataforma.
 *
 * Esse ID é utilizado em toda a aplicação para garantir o isolamento multi-tenant,
 * sendo um elemento essencial para segurança e segregação de dados entre empresas (clínicas).
 *
 * O valor é sempre um UUID (versão 4), garantindo unicidade global sem ambiguidade.
 *
 * ### Responsabilidades:
 * - Representar de forma segura e imutável o cliente atual.
 * - Ser usado como chave de partição em bancos, caches e logs.
 * - Servir como elemento de identificação principal em todos os domínios multi-tenant.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val tenantId = TenantId.random()
 * println(tenantId) // Ex: "1fcb3a9f-7f3e-46d0-88c4-fb2f71c80d1a"
 * ```
 *
 * @property value UUID do tenant, garantindo unicidade e imutabilidade.
 */
@JvmInline
value class TenantId(val value: UUID) {

    /**
     * Retorna a representação textual do UUID.
     */
    override fun toString(): String = value.toString()

    companion object {
        /**
         * Gera um novo [TenantId] com UUID aleatório (v4).
         */
        fun random(): TenantId = TenantId(UUID.randomUUID())

        /**
         * Constrói um [TenantId] a partir de uma string UUID válida.
         *
         * @param id String UUID (ex: "3a5d60d9-9e42-4d56-8102-dffab737559e")
         */
        fun fromString(id: String): TenantId = TenantId(UUID.fromString(id))
    }
}
