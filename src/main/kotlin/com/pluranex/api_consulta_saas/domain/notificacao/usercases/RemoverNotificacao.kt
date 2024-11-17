package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_REMOVER_NOTIFICACAO
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.NOTIFICACAO_NOT_FOUND
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component

@Component
class RemoverNotificacao(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(id: Long) {
        val notificacao = notificacaoRepository.buscarNotificacaoPorId(id)
            ?: throw NotFoundException(
                NOTIFICACAO_NOT_FOUND,
                "Notificação com ID $id não encontrada."
            )

        try {
            notificacaoRepository.removerNotificacao(notificacao.id)
        } catch (e: Exception) {
            throw IntegrationException(
                ERRO_AO_REMOVER_NOTIFICACAO,
                "Erro ao remover a notificação com ID $id: ${e.message}",
                e
            )
        }
    }
}
