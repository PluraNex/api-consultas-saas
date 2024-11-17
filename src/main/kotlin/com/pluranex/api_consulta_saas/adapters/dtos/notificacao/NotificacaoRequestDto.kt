package com.pluranex.api_consulta_saas.adapters.dtos.notificacao

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao

data class NotificacaoRequestDto(
    val destinatarios: Map<CanalNotificacao, String>,
    val mensagem: String,
    val tipo: TipoNotificacao,
    val configuracao: ConfiguracaoNotificacao? = null
) {
    fun toDomain(): Notificacao {
        return Notificacao(
            id = 0L,
            destinatarios = destinatarios,
            mensagem = mensagem,
            tipo = tipo,
            status = StatusNotificacao.PENDENTE,
            enviadaEm = null,
            configuracao = configuracao
        )
    }
}