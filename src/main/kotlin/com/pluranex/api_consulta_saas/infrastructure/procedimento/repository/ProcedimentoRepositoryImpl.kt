package com.pluranex.api_consulta_saas.infrastructure.procedimento.repository

import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.repository.ProcedimentoRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.ProcedimentoMapper
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ProcedimentoRepositoryImpl(
    private val procedimentoJpaRepository: ProcedimentoJpaRepository
) : ProcedimentoRepository {

    override fun salvar(procedimento: Procedimento): Procedimento {
        val model = ProcedimentoMapper.toModel(procedimento)
        val salvo = procedimentoJpaRepository.save(model)
        return ProcedimentoMapper.toDomain(salvo)
    }

    override fun buscarPorId(id: UUID): Procedimento? {
        return procedimentoJpaRepository.findById(id)
            .map { ProcedimentoMapper.toDomain(it) }
            .orElse(null)
    }

    override fun listarTodos(): List<Procedimento> {
        return procedimentoJpaRepository.findAll()
            .map { ProcedimentoMapper.toDomain(it) }
    }
}
