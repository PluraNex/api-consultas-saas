package com.pluranex.api_consulta_saas.infrastructure.repositories.notificacao

import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.infrastructure.models.NotificacaoModel
import org.springframework.data.jpa.repository.JpaRepository

interface NotificacaoJpaRepository : JpaRepository<NotificacaoModel, Long> {
    fun findAllByStatus(status: StatusNotificacao): List<NotificacaoModel>
}
