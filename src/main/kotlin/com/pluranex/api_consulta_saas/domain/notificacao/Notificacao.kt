package com.pluranex.api_consulta_saas.domain.notificacao

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import java.time.LocalDateTime

data class Notificacao(
    val id: Long,
    var destinatarios: Map<CanalNotificacao, String>,
    val mensagem: String,
    val tipo: TipoNotificacao,
    var status: StatusNotificacao = StatusNotificacao.PENDENTE,
    var enviadaEm: LocalDateTime? = null,
    var configuracao: ConfiguracaoNotificacao? = null
)
