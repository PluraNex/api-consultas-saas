package com.pluranex.api_consulta_saas.common.session.mapper

import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario as PerfilDominio
import com.pluranex.api_consulta_saas.domain.sessao.UsuarioAutenticado

/**
 * Mapeia a [SessaoUsuario] (estrutura técnica da sessão atual) para [UsuarioAutenticado],
 * que é a identidade de domínio usada em regras de negócio.
 *
 * Isso permite separar a representação técnica da sessão da representação usada no domínio.
 *
 * @return Instância de [UsuarioAutenticado] com dados mapeados do token JWT.
 */
fun SessaoUsuario.toUsuarioAutenticado(): UsuarioAutenticado {
    val perfilDominio = PerfilDominio.valueOf(perfil.codigoPerfil)

    return UsuarioAutenticado(
        userId = userId,
        tenantId = tenantId,
        perfil = perfilDominio,
        idMedico = perfil.idMedico,
        idPaciente = perfil.idPaciente
    )
}
