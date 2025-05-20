package com.pluranex.api_consulta_saas.domain.configuracao_notificacao.usecase

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import org.springframework.stereotype.Component

@Component
class ObterConfiguracaoDefault(
    private val repository: ConfiguracaoNotificacaoRepository
) {

    fun executar(): ConfiguracaoNotificacao {
        return repository.findFirstByIsDefaultTrue()
            ?: throw IllegalStateException("Nenhuma configuração default definida.")
    }
}
