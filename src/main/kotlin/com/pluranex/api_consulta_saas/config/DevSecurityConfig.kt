package com.pluranex.api_consulta_saas.config

import com.pluranex.api_consulta_saas.infrastructure.security.filter.DevAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@Profile("loc")
class DevSecurityConfig(
    private val devAuthenticationFilter: DevAuthenticationFilter
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .addFilterBefore(devAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
}
