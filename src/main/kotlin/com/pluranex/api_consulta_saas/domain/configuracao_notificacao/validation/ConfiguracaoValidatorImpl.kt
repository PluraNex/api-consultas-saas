package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.validation

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ConfiguracaoValidatorImpl : ConfiguracaoValidator {

    override fun validarNotificacaoExistente(notificacaoId: Long?) {
        if (notificacaoId== null || notificacaoId <= 0) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.NOTIFICACAO_AUSENTE_PARA_CONFIGURACAO,
                "A notificação não foi encontrada ou está ausente para a configuração solicitada."
            )
        }
    }

    override fun validarCanaisAtivos(canais: List<CanalNotificacao>) {
        if (canais.any { it !in CanalNotificacao.entries }) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.CANAL_NAO_SUPORTADO,
                "Um ou mais canais de notificação fornecidos não são suportados: ${canais.joinToString(", ")}"
            )
        }
    }

    override fun validarDataAgendada(agendadaPara: LocalDateTime?) {
        if (agendadaPara != null && agendadaPara.isBefore(LocalDateTime.now())) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.CONFIGURACAO_INVALIDA,
                "A data agendada para envio (${agendadaPara}) não pode ser no passado."
            )
        }
    }

    override fun validarNovaConfiguracaoParaNotificacao(novaConfiguracao: ConfiguracaoNotificacao, notificacaoId: Long) {
        validarNotificacaoExistente(notificacaoId)
        validarCanaisAtivos(novaConfiguracao.canaisAtivos)
        validarDataAgendada(novaConfiguracao.agendadaPara)
    }
}
