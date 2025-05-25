package com.pluranex.api_consulta_saas.infrastructure.repositories.permissao

import com.pluranex.api_consulta_saas.infrastructure.models.PermissaoModel
import org.springframework.data.jpa.repository.JpaRepository


interface PermissaoJpaRepository: JpaRepository<PermissaoModel, Long> {
    fun findAllByUsuarioId(usuarioId: Long): List<PermissaoModel>
    fun deleteAllByUsuarioId(usuarioId: Long)
    fun existsByUsuarioIdAndPermissao(usuarioId: Long, permissao: String): Boolean
}

