package com.pluranex.api_consulta_saas.infrastructure.shared.mapper

/**
 * Contrato genérico para mapeamento entre entidades de domínio e modelos JPA.
 *
 * @param D Tipo da entidade de domínio
 * @param M Tipo do modelo JPA (banco de dados)
 */
interface BaseMapper<D, M> {

    fun toDomain(model: M): D

    fun toModel(domain: D): M
}
