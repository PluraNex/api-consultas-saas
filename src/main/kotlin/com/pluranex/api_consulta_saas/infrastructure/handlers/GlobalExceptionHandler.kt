package com.pluranex.api_consulta_saas.infrastructure.handlers

import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.infrastructure.responses.ApiErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    private fun getRequestId(request: HttpServletRequest): String {
        return request.getAttribute("X-Request-ID") as? String ?: "N/A"
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        headers.add("X-Request-ID", getRequestId(request))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .headers(headers)
            .body(
                ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                error = "Erro de negócio.",
                code = ex.errorCode
            )
            )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        headers.add("X-Request-ID", getRequestId(request))
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.NOT_FOUND.value(),
                error = "Recurso não encontrado.",
                code = ex.errorCode
            ))
    }

    @ExceptionHandler(IntegrationException::class)
    fun handleIntegrationException(ex: IntegrationException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        headers.add("X-Request-ID", getRequestId(request))
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.SERVICE_UNAVAILABLE.value(),
                error = "Erro de integração com serviço externo.",
                code = ex.errorCode
            ))
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", "GEN-000")
        headers.add("X-Request-ID", getRequestId(request))
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error = "Erro inesperado. Por favor, contate o suporte.",
                code = "GEN-000"
            ))
    }
}