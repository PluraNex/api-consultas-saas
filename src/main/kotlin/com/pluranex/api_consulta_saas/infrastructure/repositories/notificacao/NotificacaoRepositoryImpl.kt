package com.pluranex.api_consulta_saas.infrastructure.repositories.notificacao

import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoRepository
import com.pluranex.api_consulta_saas.domain.notificacao.usercases.CriarNotificacao
import com.pluranex.api_consulta_saas.infrastructure.mappers.NotificacaoMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class NotificacaoRepositoryImpl(
    private val notificacaoJpaRepository: NotificacaoJpaRepository
) : NotificacaoRepository {

    companion object {
        private val logger = LoggerFactory.getLogger(CriarNotificacao::class.java)
    }

    override fun buscarNotificacaoPorId(id: Long): Notificacao? {
        return notificacaoJpaRepository.findById(id).orElse(null)?.let { NotificacaoMapper.toDomain(it) }
    }

    override fun listarNotificacoes(): List<Notificacao> {
        return notificacaoJpaRepository.findAll().map { NotificacaoMapper.toDomain(it) }
    }

    override fun criarNotificacao(notificacao: Notificacao): Notificacao {
        val model = NotificacaoMapper.toModel(notificacao)
        logger.info("Destinatários mapeados: ${notificacao.destinatarios}")
        return NotificacaoMapper.toDomain(notificacaoJpaRepository.save(model))
    }

    override fun atualizarNotificacao(notificacao: Notificacao): Notificacao {
        val model = NotificacaoMapper.toModel(notificacao)
        return NotificacaoMapper.toDomain(notificacaoJpaRepository.save(model))
    }

    override fun atualizarStatus(id: Long, status: StatusNotificacao): Notificacao? {
        val notificacaoModel = notificacaoJpaRepository.findById(id).orElse(null) ?: return null
        notificacaoModel.status = NotificacaoMapper.toModelStatus(status)
        return NotificacaoMapper.toDomain(notificacaoJpaRepository.save(notificacaoModel))
    }

    override fun listarNotificacoesPorStatus(status: StatusNotificacao): List<Notificacao> {
        return notificacaoJpaRepository.findAllByStatus(status).map { NotificacaoMapper.toDomain(it) }
    }

    override fun removerNotificacao(id: Long) {
        val notificacaoModel = notificacaoJpaRepository.findById(id).orElse(null)
        notificacaoModel?.let {
            notificacaoJpaRepository.delete(it)
        }
    }
}
