package com.pluranex.api_consulta_saas.adapters.dtos.notificacao

import ConfiguracaoNotificacaoResponseDto
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import java.time.LocalDateTime

data class NotificacaoResponseDto(
    val id: Long,
    val destinatarios: Map<CanalNotificacao, String>,
    val mensagem: String,
    val tipo: TipoNotificacao,
    val status: StatusNotificacao,
    val enviadaEm: LocalDateTime?,
    val configuracao: ConfiguracaoNotificacaoResponseDto?
) {
    companion object {
        fun fromDomain(notificacao: Notificacao): NotificacaoResponseDto {
            return NotificacaoResponseDto(
                id = notificacao.id,
                destinatarios = notificacao.destinatarios,
                mensagem = notificacao.mensagem,
                tipo = notificacao.tipo,
                status = notificacao.status,
                enviadaEm = notificacao.enviadaEm,
                configuracao = notificacao.configuracao?.let { ConfiguracaoNotificacaoResponseDto.fromDomain(it) }
            )
        }
    }
}

