package com.pluranex.api_consulta_saas.infrastructure.providers

import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao

interface NotificationProvider {
    fun enviar(notificacao: Notificacao)
}