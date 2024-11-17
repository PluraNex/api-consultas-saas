package com.pluranex.api_consulta_saas.infrastructure.mappers


import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.infrastructure.models.NotificacaoModel

object NotificacaoMapper {

    fun toModel(notificacao: Notificacao): NotificacaoModel {
        return NotificacaoModel(
            id = notificacao.id,
            destinatarios = notificacao.destinatarios.mapKeys { it.key.name },
            mensagem = notificacao.mensagem,
            tipo = NotificacaoModel.Tipo.valueOf(notificacao.tipo.name),
            status = toModelStatus(notificacao.status),
            enviadaEm = notificacao.enviadaEm,
            configuracao = notificacao.configuracao?.let { ConfiguracaoNotificacaoMapper.toModel(it) }
        )
    }

    fun toDomain(model: NotificacaoModel): Notificacao {
        return Notificacao(
            id = model.id,
            destinatarios = model.destinatarios.mapKeys { CanalNotificacao.valueOf(it.key) },
            mensagem = model.mensagem,
            tipo = TipoNotificacao.valueOf(model.tipo.name),
            status = StatusNotificacao.valueOf(model.status.name),
            enviadaEm = model.enviadaEm,
            configuracao = model.configuracao?.let { ConfiguracaoNotificacaoMapper.toDomain(it) }
        )
    }

    fun toModelStatus(status: StatusNotificacao): NotificacaoModel.Status {
        return when (status) {
            StatusNotificacao.PENDENTE -> NotificacaoModel.Status.PENDENTE
            StatusNotificacao.ENVIADA -> NotificacaoModel.Status.ENVIADA
            StatusNotificacao.FALHA -> NotificacaoModel.Status.FALHA
        }
    }
}
