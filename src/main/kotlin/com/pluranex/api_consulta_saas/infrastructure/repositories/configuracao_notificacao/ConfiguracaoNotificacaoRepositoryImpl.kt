package com.pluranex.api_consulta_saas.infrastructure.repositories.configuracao_notificacao

import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.ConfiguracaoNotificacaoMapper
import org.springframework.stereotype.Repository

@Repository
class ConfiguracaoNotificacaoRepositoryImpl(
    private val jpaRepository: ConfiguracaoNotificacaoJpaRepository
) : ConfiguracaoNotificacaoRepository {

    override fun criarConfiguracao(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacao {
        val model = ConfiguracaoNotificacaoMapper.toModel(configuracao)
        return ConfiguracaoNotificacaoMapper.toDomain(jpaRepository.save(model))
    }

    override fun buscarConfiguracaoPorId(id: Long): ConfiguracaoNotificacao? {
        return jpaRepository.findById(id).orElse(null)?.let {
            ConfiguracaoNotificacaoMapper.toDomain(it)
        }
    }

    override fun atualizarConfiguracao(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacao {
        val model = ConfiguracaoNotificacaoMapper.toModel(configuracao)
        return ConfiguracaoNotificacaoMapper.toDomain(jpaRepository.save(model))
    }

    override fun listarConfiguracoes(): List<ConfiguracaoNotificacao> {
        return jpaRepository.findAll().map { ConfiguracaoNotificacaoMapper.toDomain(it) }
    }

    override fun removerConfiguracao(id: Long): Boolean {
        return if (jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    override fun isConfiguracaoEmUso(configuracaoId: Long): Boolean {
        return jpaRepository.existsConfiguracaoEmUso(configuracaoId)
    }

    override fun findFirstByIsDefaultTrue(): ConfiguracaoNotificacao? {
        return jpaRepository.findFirstByIsDefaultTrue()?.let {
            ConfiguracaoNotificacaoMapper.toDomain(it)
        }
    }
}
