package com.pluranex.api_consulta_saas.infrastructure.repositories.permissao

import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao
import com.pluranex.api_consulta_saas.domain.permissao.PermissaoRepository
import com.pluranex.api_consulta_saas.domain.permissao.PermissaoUsuario
import com.pluranex.api_consulta_saas.infrastructure.mappers.PermissaoMapper
import org.springframework.stereotype.Repository

@Repository
class PermissaoRepositoryImpl(
    private val permissaoJpaRepository: PermissaoJpaRepository
) : PermissaoRepository {

    override fun salvar(permissao: PermissaoUsuario): PermissaoUsuario {
        val model = PermissaoMapper.toModel(permissao)
        val saved = permissaoJpaRepository.save(model)
        return PermissaoMapper.toDomain(saved)
    }

    override fun salvarTodas(permissoes: List<PermissaoUsuario>): List<PermissaoUsuario> {
        val models = permissoes.map(PermissaoMapper::toModel)
        return permissaoJpaRepository.saveAll(models).map(PermissaoMapper::toDomain)
    }

    override fun listarPorUsuarioId(usuarioId: Long): List<PermissaoUsuario> {
        return permissaoJpaRepository.findAllByUsuarioId(usuarioId).map(PermissaoMapper::toDomain)
    }

    override fun deletarPorUsuarioId(usuarioId: Long) {
        permissaoJpaRepository.deleteAllByUsuarioId(usuarioId)
    }

    override fun existePermissao(usuarioId: Long, permissao: Permissao): Boolean {
        return permissaoJpaRepository.existsByUsuarioIdAndPermissao(usuarioId, permissao.name)
    }
}
