package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.validation

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import java.time.LocalDateTime

interface ConfiguracaoValidator {
    fun validarNotificacaoExistente(notificacaoId: Long?)
    fun validarCanaisAtivos(canais: List<CanalNotificacao>)
    fun validarDataAgendada(agendadaPara: LocalDateTime?)
    fun validarNovaConfiguracaoParaNotificacao(novaConfiguracao: ConfiguracaoNotificacao,  notificacaoId: Long)

}