package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_ATUALIZAR_STATUS_NOTIFICACAO
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType.NOTIFICACAO_NOT_FOUND
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AtualizarStatusNotificacao(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(id: Long, status: StatusNotificacao) {
        try {
            val notificacao = notificacaoRepository.buscarNotificacaoPorId(id)
                ?: throw NotFoundException(
                    NOTIFICACAO_NOT_FOUND,
                    "Notificação com ID $id não encontrada."
                )
            notificacao.status = status
            if (status == StatusNotificacao.ENVIADA) {
                notificacao.enviadaEm = LocalDateTime.now()
            }

            notificacaoRepository.atualizarNotificacao(notificacao)
        } catch (e: Exception) {
            throw IntegrationException(
                 ERRO_AO_ATUALIZAR_STATUS_NOTIFICACAO,
                "Erro ao atualizar status da notificação com ID $id: ${e.message}",
                e
            )
        }
    }
}
