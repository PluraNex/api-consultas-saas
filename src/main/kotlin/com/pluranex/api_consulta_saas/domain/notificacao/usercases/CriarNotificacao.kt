package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component

@Component
class CriarNotificacao(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(notificacao: Notificacao): Notificacao {
        try {
            return notificacaoRepository.criarNotificacao(notificacao)
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_NOTIFICACAO,
                "Erro ao criar a notificação: ${e.message}"
            )
        }
    }
}