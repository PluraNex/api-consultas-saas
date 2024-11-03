package com.pluranex.api_consulta_saas.infrastructure.models
import jakarta.persistence.*

@Entity
@Table(name = "profissionais")
data class ProfissionalModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val especialidade: String,

    @Column(nullable = false, unique = true)
    val telefone: String,

    val email: String? = null
)