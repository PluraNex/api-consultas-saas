package com.pluranex.api_consulta_saas.infrastructure.repositories.profissional
import com.pluranex.api_consulta_saas.domain.entities.Profissional
import com.pluranex.api_consulta_saas.infrastructure.mappers.ProfissionalMapper
import org.springframework.stereotype.Repository

@Repository
class ProfissionalRepository(
    private val profissionalJpaRepository: ProfissionalJpaRepository
) {

    fun listarProfissionais(): List<Profissional> {
        return profissionalJpaRepository.findAll().map { ProfissionalMapper.toDomain(it) }
    }

    fun buscarProfissionalPorId(profissionalId: Long): Profissional? {
        return profissionalJpaRepository.findById(profissionalId).orElse(null)?.let { ProfissionalMapper.toDomain(it) }
    }

    fun criarProfissional(profissional: Profissional): Profissional {
        val profissionalModel = ProfissionalMapper.toModel(profissional)
        return ProfissionalMapper.toDomain(profissionalJpaRepository.save(profissionalModel))
    }

    fun atualizarProfissional(profissionalId: Long, profissional: Profissional): Profissional? {
        val profissionalExistente = profissionalJpaRepository.findById(profissionalId).orElse(null)
        return if (profissionalExistente != null) {
            val atualizado = profissionalExistente.copy(
                nome = profissional.nome,
                especialidade = profissional.especialidade,
                telefone = profissional.telefone,
                email = profissional.email
            )
            ProfissionalMapper.toDomain(profissionalJpaRepository.save(atualizado))
        } else {
            null
        }
    }

    fun excluirProfissional(profissionalId: Long): Boolean {
        return if (profissionalJpaRepository.existsById(profissionalId)) {
            profissionalJpaRepository.deleteById(profissionalId)
            true
        } else {
            false
        }
    }
}