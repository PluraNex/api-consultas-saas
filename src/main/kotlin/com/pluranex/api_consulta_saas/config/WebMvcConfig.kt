package com.pluranex.api_consulta_saas.config

import com.pluranex.api_consulta_saas.infrastructure.interceptors.RequestIdInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebMvcConfig(private val requestIdInterceptor: RequestIdInterceptor) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(requestIdInterceptor)
    }
}