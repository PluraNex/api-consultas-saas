package com.pluranex.api_consulta_saas.application.notificacao


import com.pluranex.api_consulta_saas.adapters.dtos.notificacao.NotificacaoRequestDto
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoService
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.StatusNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoService
import com.pluranex.api_consulta_saas.domain.notificacao.usercases.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificacaoServiceImpl(
    private val criarNotificacao: CriarNotificacao,
    private val atualizarStatusNotificacao: AtualizarStatusNotificacao,
    private val enviarNotificacao: EnviarNotificacao,
    private val buscarNotificacao: BuscarNotificacao,
    private val reenviarNotificacao: ReenviarNotificacao,
    private val listarNotificacoes: ListarNotificacoes,
    private val removerNotificacao: RemoverNotificacao,
    private val configuracacaoNotificacaoService: ConfiguracaoNotificacaoService

) : NotificacaoService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(NotificacaoServiceImpl::class.java)
    }

    override fun criarNotificacao(requestDto: NotificacaoRequestDto): Notificacao {
        logger.info("Iniciando criação de notificação para o destinatário: ${requestDto.destinatarios}")

        val configuracao = requestDto.configuracao ?: configuracacaoNotificacaoService.obterConfiguracaoDefault()

        logger.info("Configuração utilizada: $configuracao")

        val notificacao = requestDto.toDomain().copy(configuracao = configuracao)

        return criarNotificacao.executar(notificacao)
    }




    override fun enviarNotificacao(id: Long, canal: CanalNotificacao): Notificacao {
        logger.info("Iniciando envio da notificação com ID: $id pelo canal: $canal")
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