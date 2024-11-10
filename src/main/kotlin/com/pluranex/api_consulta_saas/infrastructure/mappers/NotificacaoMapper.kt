package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.TipoNotificacao
import com.pluranex.api_consulta_saas.infrastructure.models.NotificacaoModel

object NotificacaoMapper {

    fun toModel(notificacao: Notificacao): NotificacaoModel {
        return NotificacaoModel(
            id = notificacao.id,
            destinatario = notificacao.destinatario,
            mensagem = notificacao.mensagem,
            tipo = NotificacaoModel.Tipo.valueOf(notificacao.tipo.name),
            status = toModelStatus(notificacao.status),
            canal = toModelCanal(notificacao.canal),
            enviadaEm = notificacao.enviadaEm
        )
    }

    fun toDomain(notificacaoModel: NotificacaoModel): Notificacao {
        return Notificacao(
            id = notificacaoModel.id,
            destinatario = notificacaoModel.destinatario,
            mensagem = notificacaoModel.mensagem,
            tipo = TipoNotificacao.valueOf(notificacaoModel.tipo.name),
            status = StatusNotificacao.valueOf(notificacaoModel.status.name),
            canal = CanalNotificacao.valueOf(notificacaoModel.canal.name),
            enviadaEm = notificacaoModel.enviadaEm
        )
    }


    fun toModelStatus(status: StatusNotificacao): NotificacaoModel.Status {
        return when (status) {
            StatusNotificacao.PENDENTE -> NotificacaoModel.Status.PENDENTE
            StatusNotificacao.ENVIADA -> NotificacaoModel.Status.ENVIADA
            StatusNotificacao.FALHA -> NotificacaoModel.Status.FALHA
        }
    }

    fun toModelCanal(canal: CanalNotificacao): NotificacaoModel.Canal {
        return when(canal){
            CanalNotificacao.EMAIL -> NotificacaoModel.Canal.EMAIL
            CanalNotificacao.SMS -> NotificacaoModel.Canal.SMS
            CanalNotificacao.WHATSAPP -> NotificacaoModel.Canal.WHATSAPP
        }
    }


    private fun toDomainStatus(status: NotificacaoModel.Status): StatusNotificacao {
        return when (status) {
            NotificacaoModel.Status.PENDENTE -> StatusNotificacao.PENDENTE
            NotificacaoModel.Status.ENVIADA -> StatusNotificacao.ENVIADA
            NotificacaoModel.Status.FALHA -> StatusNotificacao.FALHA
        }
    }
}
