package com.pluranex.api_consulta_saas.config

import feign.Logger
import feign.RequestInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TwilioConfiguration {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun twilioRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template ->
            val accountSid = System.getenv("TWILIO_ACCOUNT_SID")
            val authToken = System.getenv("TWILIO_AUTH_TOKEN")

            if (accountSid.isNullOrBlank() || authToken.isNullOrBlank()) {
                throw IllegalStateException("As variáveis de ambiente TWILIO_ACCOUNT_SID e TWILIO_AUTH_TOKEN não estão configuradas.")
            }

            val authHeader = "Basic " + java.util.Base64.getEncoder().encodeToString("$accountSid:$authToken".toByteArray())
            template.header("Authorization", authHeader)
            template.header("Content-Type", "application/x-www-form-urlencoded")
        }
    }
}