package com.pluranex.api_consulta_saas.application.notificacao


import com.pluranex.api_consulta_saas.adapters.dtos.notificacao.NotificacaoRequestDto
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoService
import com.pluranex.api_consulta_saas.domain.notificacao.usercases.*
import org.springframework.stereotype.Service

@Service
class NotificacaoServiceImpl(
    private val criarNotificacao: CriarNotificacao,
    private val atualizarStatusNotificacao: AtualizarStatusNotificacao,
    private val enviarNotificacao: EnviarNotificacao,
    private val buscarNotificacao: BuscarNotificacao,
    private val reenviarNotificacao: ReenviarNotificacao,
    private val listarNotificacoes: ListarNotificacoes,
    private val removerNotificacao: RemoverNotificacao

) : NotificacaoService {

    override fun criarNotificacao(requestDto: NotificacaoRequestDto): Notificacao {
        val notificacao = requestDto.toDomain()
        return criarNotificacao.executar(notificacao)
    }

    override fun enviarNotificacao(id: Long, canal: CanalNotificacao): Notificacao {
        val notificacao = buscarNotificacao.executar(id)

        try {
            enviarNotificacao.executar(notificacao, canal)
            atualizarStatusNotificacao.executar(notificacao.id, StatusNotificacao.ENVIADA)
        } catch (e: Exception) {
            atualizarStatusNotificacao.executar(notificacao.id, StatusNotificacao.FALHA)
            throw e
        }

        return notificacao
    }

    override fun reenviarNotificacao(id: Long, canal: CanalNotificacao): Notificacao {
        val notificacao = buscarNotificacao.executar(id)

        try {
            reenviarNotificacao.executar(notificacao, canal)
            atualizarStatusNotificacao.executar(notificacao.id, StatusNotificacao.ENVIADA)
        } catch (e: Exception) {
            atualizarStatusNotificacao.executar(notificacao.id, StatusNotificacao.FALHA)
            throw e
        }

        return notificacao
    }

    override fun buscarNotificacao(id: Long): Notificacao {
        return buscarNotificacao.executar(id)
    }

    override fun listarNotificacoes(): List<Notificacao> {
        return listarNotificacoes.executar()
    }

    override fun removerNotificacao(id: Long) {
        return removerNotificacao.executar(id)
    }

}