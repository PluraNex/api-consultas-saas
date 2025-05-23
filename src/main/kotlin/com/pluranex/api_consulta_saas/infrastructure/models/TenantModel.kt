package com.pluranex.api_consulta_saas.infrastructure.models

import jakarta.persistence.*

@Entity
@Table(name = "tenant")
data class TenantModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val nome: String
)
