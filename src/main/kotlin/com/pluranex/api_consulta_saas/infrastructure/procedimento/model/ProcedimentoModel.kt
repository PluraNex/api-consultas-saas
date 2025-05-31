package com.pluranex.api_consulta_saas.infrastructure.procedimento.model

import com.pluranex.api_consulta_saas.domain.enums.procedimento.CategoriaProcedimento
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.enums.repasse.TipoRepasse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "procedimento")
data class ProcedimentoModel(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(nullable = false)
    val tenantId: UUID,

    @Enumerated(EnumType.STRING)
    val tipo: TipoProcedimento? = null,

    @Column(nullable = false)
    val nome: String,

    val descricao: String? = null,

    val duracaoMinutos: Int = 30,

    val preco: BigDecimal? = null,

    @Enumerated(EnumType.STRING)
    val tipoRepasse: TipoRepasse = TipoRepasse.PERCENTUAL,

    val valorRepasse: BigDecimal = BigDecimal.ZERO,

    val ativo: Boolean = true,

    val criadoPor: String? = null,

    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    val categoria: CategoriaProcedimento? = null
)