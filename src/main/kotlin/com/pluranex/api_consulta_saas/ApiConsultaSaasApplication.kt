package com.pluranex.api_consulta_saas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients
class ApiConsultaSaasApplication

fun main(args: Array<String>) {
	runApplication<ApiConsultaSaasApplication>(*args)
}

