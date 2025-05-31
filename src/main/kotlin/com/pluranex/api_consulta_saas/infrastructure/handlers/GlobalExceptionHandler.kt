package com.pluranex.api_consulta_saas.infrastructure.handlers

import com.pluranex.api_consulta_saas.domain.exceptions.AuthException
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.PermissionException
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

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .headers(headers)
            .body(
                ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                error = "Erro de negócio.",
            )
            )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.NOT_FOUND.value(),
                error = "Recurso não encontrado.",
            ))
    }

    @ExceptionHandler(IntegrationException::class)
    fun handleIntegrationException(ex: IntegrationException, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.SERVICE_UNAVAILABLE.value(),
                error = "Erro de integração com serviço externo.",
            ))
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception, request: HttpServletRequest): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", "GEN-000")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .headers(headers)
            .body(ApiErrorResponse(
                timestamp = LocalDateTime.now(),
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error = "Erro inesperado. Por favor, contate o suporte.",
            ))
    }

    @ExceptionHandler(PermissionException::class)
    fun handlePermissionException(
        ex: PermissionException,
        request: HttpServletRequest
    ): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .headers(headers)
            .body(
                ApiErrorResponse(
                    timestamp = LocalDateTime.now(),
                    status = HttpStatus.FORBIDDEN.value(),
                    error = ex.message ?: "Acesso negado.",
                )
            )
    }

    @ExceptionHandler(AuthException::class)
    fun handleAuthException(
        ex: AuthException,
        request: HttpServletRequest
    ): ResponseEntity<ApiErrorResponse> {
        val headers = HttpHeaders()
        headers.add("X-Error-Code", ex.errorCode)

        val status = when (ex.type) {
            AuthException.AuthExceptionType.TOKEN_INVALIDO,
            AuthException.AuthExceptionType.TOKEN_AUSENTE,
            AuthException.AuthExceptionType.TOKEN_EXPIRADO -> HttpStatus.UNAUTHORIZED

            AuthException.AuthExceptionType.USUARIO_NAO_AUTENTICADO,
            AuthException.AuthExceptionType.PERFIL_INVALIDO -> HttpStatus.FORBIDDEN

            else -> HttpStatus.UNAUTHORIZED
        }

        return ResponseEntity.status(status)
            .headers(headers)
            .body(
                ApiErrorResponse(
                    timestamp = LocalDateTime.now(),
                    status = status.value(),
                    error = ex.message ?: "Falha de autenticação.",
                )
            )
    }

}