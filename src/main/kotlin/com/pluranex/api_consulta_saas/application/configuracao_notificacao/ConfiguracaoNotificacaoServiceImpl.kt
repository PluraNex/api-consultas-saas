package com.pluranex.api_consulta_saas.application.configuracao_notificacao

import com.pluranex.api_consulta_saas.adapters.dtos.configuracao_notificacao.ConfiguracaoNotificacaoRequestDto
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoService
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecases.*
import org.springframework.stereotype.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class ConfiguracaoNotificacaoServiceImpl(
    private val criarConfiguracaoNotificacao: CriarConfiguracaoNotificacao,
    private val atualizarConfiguracaoNotificacao: AtualizarConfiguracaoNotificacao,
    private val removerConfiguracaoNotificacao: RemoverConfiguracaoNotificacao,
    private val buscarConfiguracaoNotificacao: BuscarConfiguracaoNotificacao,
    private val listarConfiguracoesNotificacao: ListarConfiguracoesNotificacao,
    private val definirConfiguracaoDefault: DefinirConfiguracaoDefault,
    private val obterConfiguracaoDefault: ObterConfiguracaoDefault
) : ConfiguracaoNotificacaoService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ConfiguracaoNotificacaoServiceImpl::class.java)
    }

    override fun criarConfiguracao(configuracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao {
        logger.info("Iniciando criação de configuração para notificação ID: $notificacaoId")
        return criarConfiguracaoNotificacao.execute(configuracao, notificacaoId)
    }

    override fun atualizarConfiguracao(novaConfiguracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao {
        logger.info("Atualizando configuração para a notificação com ID: $notificacaoId")
        return atualizarConfiguracaoNotificacao.execute(novaConfiguracao, notificacaoId)
    }

    override fun removerConfiguracao(id: Long) {
        logger.info("Iniciando remoção da configuração de notificação com ID: $id")
        removerConfiguracaoNotificacao.execute(id)
    }

    override fun buscarConfiguracao(id: Long): ConfiguracaoNotificacao {
        logger.info("Iniciando busca pela configuração de notificação com ID: $id")
        return buscarConfiguracaoNotificacao.execute(id)
    }

    override fun listarConfiguracoes(): List<ConfiguracaoNotificacao> {
        logger.info("Iniciando listagem de configurações de notificação.")
        return listarConfiguracoesNotificacao.execute()
    }

    override fun definirConfiguracaoDefault(configuracaoDefaultDto: ConfiguracaoNotificacaoRequestDto): ConfiguracaoNotificacao {
        logger.info("Iniciando definição de configuração default.")
        val configuracaoDefault= configuracaoDefaultDto.toDomain()
        return definirConfiguracaoDefault.executar(configuracaoDefault)
    }

    override fun obterConfiguracaoDefault(): ConfiguracaoNotificacao {
        logger.info("obtendo configuração default.")
        return obterConfiguracaoDefault.executar()
    }

}
