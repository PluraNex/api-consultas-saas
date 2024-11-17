package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.infrastructure.models.ConfiguracaoNotificacaoModel

object ConfiguracaoNotificacaoMapper {

    fun toModel(domain: ConfiguracaoNotificacao): ConfiguracaoNotificacaoModel {
        return ConfiguracaoNotificacaoModel(
            id = domain.id, // Inclua o campo ID
            canaisAtivos = domain.canaisAtivos,
            agendadaPara = domain.agendadaPara,
            tempoAntecedenciaLembrete = domain.tempoAntecedenciaLembrete,
            tempoAntecedenciaConfirmacao = domain.tempoAntecedenciaConfirmacao,
            isDefault = domain.isDefault
        )
    }

    fun toDomain(model: ConfiguracaoNotificacaoModel): ConfiguracaoNotificacao {
        return ConfiguracaoNotificacao(
            id = model.id, // Inclua o campo ID
            canaisAtivos = model.canaisAtivos,
            agendadaPara = model.agendadaPara,
            tempoAntecedenciaLembrete = model.tempoAntecedenciaLembrete,
            tempoAntecedenciaConfirmacao = model.tempoAntecedenciaConfirmacao,
            isDefault = model.isDefault
        )
    }
}
