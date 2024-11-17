package com.pluranex.api_consulta_saas.domain.configuracao_notificacao

import com.pluranex.api_consulta_saas.adapters.dtos.configuracao_notificacao.ConfiguracaoNotificacaoRequestDto


interface ConfiguracaoNotificacaoService {
    fun criarConfiguracao(configuracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao
    fun atualizarConfiguracao(novaConfiguracao: ConfiguracaoNotificacao, notificacaoId: Long): ConfiguracaoNotificacao
    fun removerConfiguracao(id: Long)
    fun buscarConfiguracao(id: Long): ConfiguracaoNotificacao
    fun listarConfiguracoes(): List<ConfiguracaoNotificacao>
    fun definirConfiguracaoDefault(configuracaoDefaultDto: ConfiguracaoNotificacaoRequestDto): ConfiguracaoNotificacao
    fun obterConfiguracaoDefault(): ConfiguracaoNotificacao
}
