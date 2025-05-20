package com.pluranex.api_consulta_saas.domain.notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao

interface NotificacaoRepository {
    fun salvar(notificacao: Notificacao): Notificacao
    fun buscarPorId(id: Long): Notificacao?
    fun listarTodos(): List<Notificacao>
    fun listarPorStatus(status: StatusNotificacao): List<Notificacao>
    fun atualizarStatus(id: Long, status: StatusNotificacao): Notificacao?
    fun remover(id: Long)
}

