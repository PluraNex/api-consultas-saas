package com.pluranex.api_consulta_saas.infrastructure.repositories.empresa

import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaudeRepository
import com.pluranex.api_consulta_saas.infrastructure.mappers.EmpresaSaudeMapper
import org.springframework.stereotype.Repository

@Repository
class EmpresaSaudeRepositoryImpl(
    private val empresaSaudeJpaRepository: EmpresaSaudeJpaRepository
) : EmpresaSaudeRepository {

    override fun salvar(empresa: EmpresaSaude): EmpresaSaude {
        val model = EmpresaSaudeMapper.toModel(empresa)
        val saved = empresaSaudeJpaRepository.save(model)
        return EmpresaSaudeMapper.toDomain(saved)
    }

    override fun buscarPorId(id: Long): EmpresaSaude? {
        return empresaSaudeJpaRepository.findById(id).orElse(null)?.let { EmpresaSaudeMapper.toDomain(it) }
    }

    override fun listarTodas(): List<EmpresaSaude> {
        return empresaSaudeJpaRepository.findAll().map { EmpresaSaudeMapper.toDomain(it) }
    }
}
