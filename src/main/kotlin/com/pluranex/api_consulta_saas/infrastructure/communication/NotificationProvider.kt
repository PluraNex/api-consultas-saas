package com.pluranex.api_consulta_saas.infrastructure.communication

import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao

interface NotificationProvider {
    fun enviar(notificacao: Notificacao)
}