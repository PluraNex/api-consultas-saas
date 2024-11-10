package com.pluranex.api_consulta_saas.infrastructure.responses

import java.time.LocalDateTime

data class ApiErrorResponse(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val code: String,
    val requestId: String? = null
)