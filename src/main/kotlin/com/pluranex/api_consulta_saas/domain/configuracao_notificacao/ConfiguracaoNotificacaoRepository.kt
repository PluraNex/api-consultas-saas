package com.pluranex.api_consulta_saas.domain.configuracao_notificacao

interface ConfiguracaoNotificacaoRepository {
    fun criarConfiguracao(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacao
    fun atualizarConfiguracao(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacao
    fun buscarConfiguracaoPorId(id: Long): ConfiguracaoNotificacao?
    fun listarConfiguracoes(): List<ConfiguracaoNotificacao>
    fun removerConfiguracao(id: Long): Boolean
    fun isConfiguracaoEmUso(configuracaoId: Long): Boolean
    fun findFirstByIsDefaultTrue(): ConfiguracaoNotificacao?

}