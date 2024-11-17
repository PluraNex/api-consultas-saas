package com.pluranex.api_consulta_saas.infrastructure.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "notificacoes")
data class NotificacaoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ElementCollection
    @CollectionTable(name = "notificacao_destinatarios", joinColumns = [JoinColumn(name = "notificacao_id")])
    @MapKeyColumn(name = "canal")
    @Column(name = "destinatario", nullable = false)
    val destinatarios: Map<String, String>,

    @Column(nullable = false)
    val mensagem: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val tipo: Tipo,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: Status,

    @CreationTimestamp
    @Column(name = "enviada_em", updatable = false)
    val enviadaEm: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuracao_id", referencedColumnName = "id", nullable = true)
    var configuracao: ConfiguracaoNotificacaoModel? = null

) {
    enum class Tipo {
        CONFIRMACAO,
        LEMBRETE,
        CANCELAMENTO,
        REMARCACAO
    }

    enum class Status {
        PENDENTE,
        ENVIADA,
        FALHA
    }
}
