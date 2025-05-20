package com.pluranex.api_consulta_saas.infrastructure.models

import jakarta.persistence.*

@Entity
@Table(name = "empresas_saude")
data class EmpresaSaudeModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val nome: String
)
