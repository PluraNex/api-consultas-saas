package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AtualizarStatusNotificacao(
    private val notificacaoRepository: NotificacaoRepository
) {
    fun executar(id: Long, status: StatusNotificacao) {
        val notificacao = notificacaoRepository.buscarNotificacaoPorId(id)
            ?: throw NotFoundException(NotFoundException.NotFoundExceptionType.NOTIFICACAO_NOT_FOUND, "Notificação não encontrada.")

        notificacao.status = status
        if (status == StatusNotificacao.ENVIADA) {
            notificacao.enviadaEm = LocalDateTime.now()
        }
        notificacaoRepository.atualizarNotificacao(notificacao)
    }
}