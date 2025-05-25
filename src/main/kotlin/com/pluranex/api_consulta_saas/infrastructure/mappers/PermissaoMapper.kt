
package com.pluranex.api_consulta_saas.infrastructure.mappers

import com.pluranex.api_consulta_saas.domain.permissao.PermissaoUsuario
import com.pluranex.api_consulta_saas.infrastructure.models.PermissaoModel
import com.pluranex.api_consulta_saas.infrastructure.models.UsuarioModel

object PermissaoMapper {
    fun toDomain(model: PermissaoModel): PermissaoUsuario =
        PermissaoUsuario(
            permissao = model.permissao,
            escopo = model.escopo,
            atribuidaPor = model.atribuidaPor,
            atribuidaEm = model.atribuidaEm
        )

    fun toModel(usuario: UsuarioModel, entity: PermissaoUsuario): PermissaoModel =
        PermissaoModel(
            usuario = usuario,
            permissao = entity.permissao,
            escopo = entity.escopo,
            atribuidaPor = entity.atribuidaPor,
            atribuidaEm = entity.atribuidaEm
        )
}