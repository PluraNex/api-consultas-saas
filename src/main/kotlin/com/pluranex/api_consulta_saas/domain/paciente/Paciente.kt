package com.pluranex.api_consulta_saas.domain.paciente

data class Paciente(
    val id: Long? = null,
    val nome: String,
    val telefone: String,
    val email: String?
)


data class Paciente(
    val id: UUID,
    val nome: String,
    val cpf: String,
    val email: String,
    val nascimento: LocalDate,
    val sexo: Sexo,
    val documentoAlternativo: Documento?,
    val celular: Telefone,
    val telefoneFixo: Telefone?,
    val imagemPerfilUrl: String?,
    val codigoInterno: String,
    val privacidadeAtivada: Boolean = false
)