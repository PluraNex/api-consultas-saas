package com.pluranex.api_consulta_saas.common.types.tenant

import java.util.*

/**
 * Identificador único de um tenant (cliente) da plataforma.
 *
 * Esse ID é utilizado em todo o sistema para isolar dados entre clínicas e empresas,
 * sendo uma das peças-chave da arquitetura multi-tenant.
 *
 * Por convenção, o valor pode ser um UUID ou um slug legível (ex: "clinica-vida").
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val tenantId = TenantId.generate()
 * println(tenantId.value) // "1fcb3a9f-7f3e-46d0-88c4-fb2f71c80d1a"
 * ```
 *
 * @property value Valor único e imutável associado ao tenant.
 */
@JvmInline
value class TenantId(val value: String) {
    override fun toString(): String = value

    companion object {
        /**
         * Gera um novo `TenantId` baseado em UUID v4.
         */
        fun generate(): TenantId = TenantId(UUID.randomUUID().toString())

        /**
         * Cria um `TenantId` a partir de um valor de slug ou código existente.
         */
        fun from(codigo: String): TenantId = TenantId(codigo.lowercase().replace(" ", "-"))
    }
}
