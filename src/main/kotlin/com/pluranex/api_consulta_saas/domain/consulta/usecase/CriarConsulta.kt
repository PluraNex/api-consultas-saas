package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import org.springframework.stereotype.Component

@Component
class CriarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(consulta: Consulta): Consulta {
        try {
            return consultaRepository.criarConsulta(consulta)
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_CONSULTA,
                "Erro ao criar consulta: ${e.message}"
            )
        }
    }
}