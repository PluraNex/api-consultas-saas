package com.pluranex.api_consulta_saas.domain.entities

data class Profissional(
    val id: Long? = null,
    val nome: String,
    val especialidade: String,
    val telefone: String,
    val email: String?
)