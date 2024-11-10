package com.pluranex.api_consulta_saas.adapters.dtos.notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao


data class NotificacaoRequestDto(
    val destinatario: String,
    val mensagem: String,
    val tipo: TipoNotificacao,
    val canal: CanalNotificacao
) {
    fun toDomain(): Notificacao {
        return Notificacao(
            id = 0L,
            destinatario = destinatario,
            mensagem = mensagem,
            tipo = tipo,
            canal = canal,
            status = StatusNotificacao.PENDENTE,
            enviadaEm = null
        )
    }
}