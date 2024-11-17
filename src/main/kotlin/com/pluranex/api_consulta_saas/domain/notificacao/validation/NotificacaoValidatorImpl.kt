package com.pluranex.api_consulta_saas.domain.notificacao.validation

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificacaoValidatorImpl : NotificacaoValidator {

    override fun validarStatusParaEnvio(notificacao: Notificacao) {
        if (notificacao.status == StatusNotificacao.ENVIADA) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.NOTIFICACAO_JA_ENVIADA,
                "A notificação já foi enviada e não pode ser reenviada."
            )
        }
    }

    override fun validarCanal(canal: CanalNotificacao) {
        if (canal !in CanalNotificacao.entries.toTypedArray()) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.CANAL_NAO_SUPORTADO,
                "Canal de notificação $canal não é suportado."
            )
        }
    }


    override fun validarStatusParaReenvio(notificacao: Notificacao) {
        if (notificacao.status != StatusNotificacao.FALHA) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.FALHA_NO_REENVIO,
                "A notificação não está em estado de falha para ser reenviada."

            )
        }
    }

    override fun validarNotificacaoExistente(notificacao: Notificacao?) {
        if (notificacao == null || notificacao.id <= 0) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.NOTIFICACAO_AUSENTE_PARA_CONFIGURACAO,
                "A notificação não foi encontrada ou está ausente para o contexto solicitado."
            )
        }
    }

    override fun validarDestinatarios(notificacao: Notificacao) {
        // Verifica se o mapa de destinatários está vazio
        if (notificacao.destinatarios.isEmpty()) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.DESTINATARIO_INVALIDO,
                "A notificação não possui destinatários."
            )
        }

        // Filtrando destinatários nulos, vazios ou em branco
        val destinatariosValidos = notificacao.destinatarios.filterValues { destinatario ->
            destinatario.isNotBlank()
        }

        // Verificar se existe pelo menos um destinatário válido
        if (destinatariosValidos.isEmpty()) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.DESTINATARIO_INVALIDO,
                "A notificação não possui destinatários válidos."
            )
        }

        // Atualizando a lista de destinatários para conter apenas os válidos
        notificacao.destinatarios = destinatariosValidos
    }



    override fun validarCanalAtivoNaConfiguracao(notificacao: Notificacao, canal: CanalNotificacao) {
        if (canal !in notificacao.configuracao?.canaisAtivos.orEmpty()) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.CANAL_NAO_SUPORTADO,
                "O canal $canal não está configurado como ativo para a notificação com ID ${notificacao.id}."
            )
        }
    }

}
