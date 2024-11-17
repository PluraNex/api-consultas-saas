package com.pluranex.api_consulta_saas.infrastructure.models

import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import jakarta.persistence.*
import java.time.Duration
import java.time.LocalDateTime

@Entity
@Table(name = "configuracoes_notificacao")
data class ConfiguracaoNotificacaoModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
        name = "configuracao_canais_ativos",
        joinColumns = [JoinColumn(name = "configuracao_id")]
    )
    @Column(name = "canal_notificacao", nullable = false)
    val canaisAtivos: List<CanalNotificacao> = mutableListOf(CanalNotificacao.WHATSAPP),

    @Column(name = "agendada_para", nullable = true)
    val agendadaPara: LocalDateTime? = null,

    @Column(name = "tempo_antecedencia_lembrete", nullable = false)
    val tempoAntecedenciaLembrete: Duration = Duration.ofHours(24),

    @Column(name = "tempo_antecedencia_confirmacao", nullable = false)
    val tempoAntecedenciaConfirmacao: Duration = Duration.ofMinutes(30),

    @Column(name = "is_default", nullable = false)
    val isDefault: Boolean = false
)