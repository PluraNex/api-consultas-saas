package com.pluranex.api_consulta_saas.domain.repasse

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.repasse.TipoRepasse
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class Repasse(
    val id: Long? = null,
    val tenantId: TenantId,
    val procedimentoId: UUID,
    val profissionalId: UUID,
    val tipo: TipoRepasse = TipoRepasse.PERCENTUAL,
    val valor: BigDecimal,
    val validoDesde: LocalDateTime = LocalDateTime.now(),
    val validoAte: LocalDateTime? = null,
    val criadoPor: String? = null
)