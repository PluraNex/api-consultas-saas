package com.pluranex.api_consulta_saas.common.session.core

import com.pluranex.api_consulta_saas.common.session.enums.OrigemPerfil
import java.io.Serializable

/**
 * Representa as informações do perfil ativo do usuário durante a sessão atual.
 *
 * Essa classe não é o modelo de domínio `Usuario`, mas sim uma projeção do
 * estado atual da identidade do usuário logado, normalmente extraído do token JWT.
 *
 * @property codigoPerfil Código do perfil funcional ativo (ex: "MEDICO", "ADMIN", "PACIENTE")
 * @property tipoOrigemPerfil Origem técnica ou organizacional do perfil (ex: PROFISSIONAL_SAUDE)
 * @property isAdmin Define se o perfil possui permissões administrativas
 * @property isMaster Define se o perfil é um superusuário com acesso total
 * @property idMedico ID do médico associado, se aplicável
 * @property idPaciente ID do paciente associado, se aplicável
 */
data class PerfilUsuario(
    val codigoPerfil: String,
    val tipoOrigemPerfil: OrigemPerfil,
    val isAdmin: Boolean,
    val isMaster: Boolean,
    val idMedico: String?,
    val idPaciente: String?
)