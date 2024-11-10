package com.pluranex.api_consulta_saas.infrastructure.responses

data class TwilioResponse(
    val sid: String,
    val status: String,
    val errorMessage: String? = null
)