package com.pluranex.api_consulta_saas.domain.notificacao.usecase

import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException
import com.pluranex.api_consulta_saas.domain.exceptions.IntegrationException.IntegrationExceptionType.ERRO_AO_CRIAR_NOTIFICACAO
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import com.pluranex.api_consulta_saas.domain.notificacao.validation.NotificacaoValidator
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CriarNotificacao(
    private val notificacaoRepository: NotificacaoRepository,
    private val notificacaoValidator: NotificacaoValidator
) {

    companion object {
        private val logger = LoggerFactory.getLogger(CriarNotificacao::class.java)
    }

    fun executar(notificacao: Notificacao): Notificacao {

       notificacaoValidator.validarDestinatarios(notificacao)

        return try {
            notificacaoRepository.salvar(notificacao).also {
                logger.info("Notificação criada com sucesso para o ID: ${it.id}")
                logger.info("Configuracao salva:${it.configuracao}" )

            }
        } catch (e: Exception) {
            logger.error("Erro ao criar a notificação: ${e.message}", e)
            throw IntegrationException(
                ERRO_AO_CRIAR_NOTIFICACAO,
                "Erro ao criar a notificação para o destinatário: ${notificacao.destinatarios}",
                e
            )
        }
    }
}
