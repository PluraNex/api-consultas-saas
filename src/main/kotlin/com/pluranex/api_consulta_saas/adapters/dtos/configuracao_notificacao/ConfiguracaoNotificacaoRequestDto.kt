package com.pluranex.api_consulta_saas.adapters.dtos.configuracao_notificacao

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.Duration
import java.time.LocalDateTime

data class ConfiguracaoNotificacaoRequestDto(
    val id: Long? = null,
    val canaisAtivos: MutableList<CanalNotificacao> =  mutableListOf(CanalNotificacao.WHATSAPP),
    val agendadaPara: LocalDateTime = LocalDateTime.now().plusDays(1),
    val tempoAntecedenciaLembrete: Duration = Duration.ofHours(24),
    val tempoAntecedenciaConfirmacao: Duration = Duration.ofMinutes(30)

) {

    fun toDomain(): ConfiguracaoNotificacao {
        return ConfiguracaoNotificacao(
            id = id ?: 0L,
            canaisAtivos = canaisAtivos,
            agendadaPara = agendadaPara,
            tempoAntecedenciaLembrete = tempoAntecedenciaLembrete,
            tempoAntecedenciaConfirmacao = tempoAntecedenciaConfirmacao
        )
    }
}
