package com.pluranex.api_consulta_saas.domain.paciente

data class Paciente(
    val id: Long? = null,
    val nome: String,
    val telefone: String,
    val email: String?
)