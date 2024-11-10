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

    @Column(nullable = false)
    val destinatario: String,

    @Column(nullable = false)
    val mensagem: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val tipo: Tipo,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: Status,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val canal: Canal,

    @CreationTimestamp
    @Column(name = "enviada_em", updatable = false)
    val enviadaEm: LocalDateTime? = null,
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

    enum class Canal {
        WHATSAPP,
        EMAIL,
        SMS
    }
}
