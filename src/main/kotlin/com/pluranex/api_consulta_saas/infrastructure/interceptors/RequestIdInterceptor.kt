package com.pluranex.api_consulta_saas.infrastructure.interceptors

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import java.util.*


@Component
class RequestIdInterceptor : HandlerInterceptor {

    companion object {
        const val REQUEST_ID_HEADER = "X-Request-ID"
        private val logger = LoggerFactory.getLogger(RequestIdInterceptor::class.java)
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val requestId = request.getHeader(REQUEST_ID_HEADER) ?: UUID.randomUUID().toString()
        response.setHeader(REQUEST_ID_HEADER, requestId)
        request.setAttribute(REQUEST_ID_HEADER, requestId)
        logger.info("Request ID: $requestId - URI: ${request.requestURI}")
        return true
    }
}
