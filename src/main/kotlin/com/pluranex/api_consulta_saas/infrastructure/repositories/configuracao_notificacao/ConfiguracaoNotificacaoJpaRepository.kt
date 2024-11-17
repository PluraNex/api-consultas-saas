package com.pluranex.api_consulta_saas.infrastructure.repositories.configuracao_notificacao

import com.pluranex.api_consulta_saas.infrastructure.models.ConfiguracaoNotificacaoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ConfiguracaoNotificacaoJpaRepository : JpaRepository<ConfiguracaoNotificacaoModel, Long> {

    @Query("SELECT COUNT(n) > 0 FROM NotificacaoModel n WHERE n.configuracao.id = :configuracaoId")
    fun existsConfiguracaoEmUso(@Param("configuracaoId") configuracaoId: Long): Boolean

    fun findFirstByIsDefaultTrue(): ConfiguracaoNotificacaoModel?
}