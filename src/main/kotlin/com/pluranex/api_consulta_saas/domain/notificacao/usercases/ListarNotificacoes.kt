package com.pluranex.api_consulta_saas.domain.notificacao.usercases

import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import org.springframework.stereotype.Component

@Component
class ListarNotificacoes(
    private val notificacaoRepository: NotificacaoRepository
) {

    fun executar(): List<Notificacao> {
        return try {
            val notificacoes = notificacaoRepository.listarNotificacoes()

            if (notificacoes.isEmpty()) {
                throw IllegalStateException("Nenhuma notificação encontrada.")
            }

            notificacoes
        } catch (e: Exception) {
            throw RuntimeException("Erro ao listar notificações: ${e.message}", e)
        }
    }
}