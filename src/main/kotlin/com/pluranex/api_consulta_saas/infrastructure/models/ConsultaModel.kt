package com.pluranex.api_consulta_saas.infrastructure.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
@Table(name = "consultas")
data class ConsultaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    val paciente: PacienteModel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", nullable = false)
    val profissional: ProfissionalModel,

    @Column(name = "data_horario", nullable = false)
    val dataHorario: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: Status = Status.PENDENTE,

    @Column(name = "observacoes", length = 500)
    var observacoes: String? = null,

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(name = "atualizado_em", nullable = false)
    var atualizadoEm: LocalDateTime = LocalDateTime.now()
) {
    enum class Status {
        PENDENTE,
        CONFIRMADA,
        CANCELADA,
        FINALIZADA
    }
}