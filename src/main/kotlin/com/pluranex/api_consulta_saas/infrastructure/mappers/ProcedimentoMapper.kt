package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import com.pluranex.api_consulta_saas.infrastructure.procedimento.model.ProcedimentoModel

object ProcedimentoMapper {

    fun toDomain(model: ProcedimentoModel): Procedimento =
        Procedimento(
            id = model.id,
            tenantId = TenantId(model.tenantId),
            tipo = model.tipo,
            nome = model.nome,
            descricao = model.descricao,
            duracaoMinutos = model.duracaoMinutos,
            preco = model.preco,
            tipoRepasse = model.tipoRepasse,
            valorRepasse = model.valorRepasse,
            ativo = model.ativo,
            criadoPor = model.criadoPor,
            criadoEm = model.criadoEm,
            categoria = model.categoria
        )

    fun toModel(domain: Procedimento): ProcedimentoModel =
        ProcedimentoModel(
            id = domain.id,
            tenantId = domain.tenantId.value,
            tipo = domain.tipo,
            nome = domain.nome,
            descricao = domain.descricao,
            duracaoMinutos = domain.duracaoMinutos,
            preco = domain.preco,
            tipoRepasse = domain.tipoRepasse,
            valorRepasse = domain.valorRepasse,
            ativo = domain.ativo,
            criadoPor = domain.criadoPor,
            criadoEm = domain.criadoEm,
            categoria = domain.categoria
        )
}
