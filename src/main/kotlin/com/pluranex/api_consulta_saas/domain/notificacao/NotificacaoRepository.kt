package com.pluranex.api_consulta_saas.domain.notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao

interface NotificacaoRepository {
    fun buscarNotificacaoPorId(id: Long): Notificacao?
    fun listarNotificacoes(): List<Notificacao>
    fun criarNotificacao(notificacao: Notificacao): Notificacao
    fun atualizarNotificacao(notificacao: Notificacao): Notificacao
    fun atualizarStatus(id: Long, status: StatusNotificacao): Notificacao?
    fun listarNotificacoesPorStatus(status: StatusNotificacao): List<Notificacao>
    fun removerNotificacao(id: Long)
}
