package com.pluranex.api_consulta_saas.domain.notificacao.validation

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao

interface NotificacaoValidator {

    fun validarStatusParaEnvio(notificacao: Notificacao)
    fun validarCanal(canal: CanalNotificacao)
    fun validarStatusParaReenvio(notificacao: Notificacao)
    fun validarNotificacaoExistente(notificacao: Notificacao?)
    fun validarDestinatarios(notificacao: Notificacao)
    fun validarCanalAtivoNaConfiguracao(notificacao: Notificacao, canal: CanalNotificacao)
}

