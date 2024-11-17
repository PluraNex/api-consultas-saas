package com.pluranex.api_consulta_saas.domain.configuracao_notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.Duration
import java.time.LocalDateTime

data class ConfiguracaoNotificacao(
    val id: Long? = null,
    val canaisAtivos: List<CanalNotificacao> = mutableListOf(CanalNotificacao.WHATSAPP),
    val agendadaPara: LocalDateTime? = null,
    val tempoAntecedenciaLembrete: Duration = Duration.ofHours(24),
    val tempoAntecedenciaConfirmacao: Duration = Duration.ofMinutes(30),
    val isDefault: Boolean = false
)