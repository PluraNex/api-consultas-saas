package com.pluranex.api_consulta_saas.infrastructure.repositories.profissional

import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.ProfissionalRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.ProfissionalMapper
import org.springframework.stereotype.Repository

@Repository
class ProfissionalRepositoryImpl(
    private val profissionalJpaRepository: ProfissionalJpaRepository
) : ProfissionalRepository {

    override fun listarProfissionais(): List<Profissional> {
        return profissionalJpaRepository.findAll().map { ProfissionalMapper.toDomain(it) }
    }

    override fun buscarProfissionalPorId(id: Long): Profissional? {
        return profissionalJpaRepository.findById(id).orElse(null)?.let { ProfissionalMapper.toDomain(it) }
    }

    override fun criarProfissional(profissional: Profissional): Profissional {
        val model = ProfissionalMapper.toModel(profissional)
        return ProfissionalMapper.toDomain(profissionalJpaRepository.save(model))
    }

    override fun atualizarProfissional(profissionalId: Long, profissional: Profissional): Profissional? {
        val profissionalExistente = profissionalJpaRepository.findById(profissionalId).orElse(null)
            ?: return null

        val atualizado = profissionalExistente.copy(
            nome = profissional.nome,
            especialidade = profissional.especialidade,
            telefone = profissional.telefone,
            email = profissional.email
        )

        return ProfissionalMapper.toDomain(profissionalJpaRepository.save(atualizado))
    }

    override fun excluirProfissional(profissionalId: Long): Boolean {
        return if (profissionalJpaRepository.existsById(profissionalId)) {
            profissionalJpaRepository.deleteById(profissionalId)
            true
        } else {
            false
        }
    }
}
