package com.pluranex.api_consulta_saas.domain.notificacao

import com.pluranex.api_consulta_saas.adapters.dtos.notificacao.NotificacaoRequestDto
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao


interface NotificacaoService {
    fun criarNotificacao(requestDto: NotificacaoRequestDto): Notificacao
    fun enviarNotificacao(id: Long, canal: CanalNotificacao): Notificacao
    fun reenviarNotificacao(id: Long, canal: CanalNotificacao): Notificacao
    fun buscarNotificacao(id: Long): Notificacao
    fun listarNotificacoes(): List<Notificacao>
    fun removerNotificacao(id: Long)
}

