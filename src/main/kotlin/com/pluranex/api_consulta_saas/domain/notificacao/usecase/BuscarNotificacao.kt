package com.pluranex.api_consulta_saas.domain.notificacao.usecase

import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component

@Component
class BuscarNotificacao(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(id: Long): Notificacao {
        return notificacaoRepository.buscarPorId(id)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.NOTIFICACAO_NOT_FOUND,
                "Notificação com ID $id não encontrada."
            )
    }
}
