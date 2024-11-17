package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException.NotFoundExceptionType
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component

@Component
class ListarNotificacoes(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(): List<Notificacao> {
        return try {
            notificacaoRepository.listarNotificacoes()
                .takeIf { it.isNotEmpty() }
                ?: throw NotFoundException(
                    NotFoundExceptionType.NOTIFICACAO_NOT_FOUND,
                    "Nenhuma notificação encontrada no sistema."
                )
        } catch (e: Exception) {
            throw IntegrationException(
                IntegrationException.IntegrationExceptionType.ERRO_AO_LISTAR_NOTIFICACOES,
                "Erro ao listar notificações: ${e.message}",
                e
            )
        }
    }

}
