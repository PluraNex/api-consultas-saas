package com.pluranex.api_consulta_saas.adapters.procedimento.dto.request

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.enums.repasse.TipoRepasse
import com.pluranex.api_consulta_saas.domain.enums.procedimento.extension.toCategoria
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import java.math.BigDecimal

/**
 * Representa a requisição para criação de um procedimento.
 *
 * A categoria é inferida automaticamente a partir do tipo de procedimento.
 */
data class CriarProcedimentoRequest(
    val tenantId: String,
    val tipo: TipoProcedimento,
    val nome: String,
    val descricao: String? = null,
    val duracaoMinutos: Int = 30,
    val preco: BigDecimal? = null,
    val tipoRepasse: TipoRepasse = TipoRepasse.PERCENTUAL,
    val valorRepasse: BigDecimal = BigDecimal.ZERO
) {
    fun toDomain(): Procedimento {
        return Procedimento(
            tenantId = TenantId.fromString(tenantId),
            tipo = tipo,
            nome = nome,
            descricao = descricao,
            duracaoMinutos = duracaoMinutos,
            preco = preco,
            tipoRepasse = tipoRepasse,
            valorRepasse = valorRepasse,
            categoria = tipo.toCategoria()
        )
    }
}
