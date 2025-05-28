package com.pluranex.api_consulta_saas.domain.procedimento

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.procedimento.CategoriaProcedimento
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.enums.repasse.TipoRepasse
import java.math.BigDecimal
import java.time.LocalDateTime

data class Procedimento(
    val id: Long? = null,
    val tenantId: TenantId,
    val tipo: TipoProcedimento? = null,
    val nome: String,
    val descricao: String? = null,
    val duracaoMinutos: Int = 30,
    val preco: BigDecimal? = null,
    val tipoRepasse: TipoRepasse = TipoRepasse.PERCENTUAL,
    val valorRepasse: BigDecimal = BigDecimal.ZERO,
    val ativo: Boolean = true,
    val criadoPor: String? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now(),
    val categoria: CategoriaProcedimento? = null
)
