package com.pluranex.api_consulta_saas.domain.endereco

import com.pluranex.api_consulta_saas.common.types.localizacao.Cep

data class Endereco(
    val rua: String,
    val numero: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val cep: Cep
)
