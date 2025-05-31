package com.pluranex.api_consulta_saas.adapters.procedimento.dto.response

import com.pluranex.api_consulta_saas.domain.enums.procedimento.CategoriaProcedimento
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.enums.repasse.TipoRepasse
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Representa a resposta retornada após a criação ou consulta de um procedimento.
 *
 * Expõe os dados relevantes da entidade [Procedimento] no formato adequado para APIs.
 */
data class ProcedimentoResponse(
    val id: UUID?,
    val tenantId: String,
    val tipo: TipoProcedimento,
    val nome: String,
    val descricao: String?,
    val duracaoMinutos: Int,
    val preco: BigDecimal?,
    val tipoRepasse: TipoRepasse,
    val valorRepasse: BigDecimal,
    val ativo: Boolean,
    val criadoPor: String?,
    val criadoEm: LocalDateTime,
    val categoria: CategoriaProcedimento?
) {
    companion object {
        fun fromDomain(procedimento: Procedimento): ProcedimentoResponse {
            return ProcedimentoResponse(
                id = procedimento.id,
                tenantId = procedimento.tenantId.toString(),
                tipo = procedimento.tipo,
                nome = procedimento.nome,
                descricao = procedimento.descricao,
                duracaoMinutos = procedimento.duracaoMinutos,
                preco = procedimento.preco,
                tipoRepasse = procedimento.tipoRepasse,
                valorRepasse = procedimento.valorRepasse,
                ativo = procedimento.ativo,
                criadoPor = procedimento.criadoPor,
                criadoEm = procedimento.criadoEm,
                categoria = procedimento.categoria
            )
        }
    }
}
