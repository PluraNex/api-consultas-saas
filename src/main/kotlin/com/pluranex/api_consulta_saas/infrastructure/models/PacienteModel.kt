package com.pluranex.api_consulta_saas.infrastructure.models

import jakarta.persistence.*
@Entity
@Table(name = "pacientes")
data class PacienteModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val telefone: String,
    val email: String?
)