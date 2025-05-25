package com.pluranex.api_consulta_saas.common.session.core

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import java.io.Serializable

/**
 * Representa a sessão autenticada de um usuário.
 *
 * Usada durante o ciclo de vida da requisição HTTP, contendo dados do usuário, tenant e perfil atual.
 *
 * ### Responsabilidades:
 * - Transportar a identidade autenticada do usuário
 * - Informar o tenant em contexto
 * - Fornecer o contexto operacional e permissões da sessão
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val sessao = auth.principal as SessaoUsuario
 * if (sessao.contexto.tipoPlano == PlanoTenant.PRO) { ... }
 * ```
 *
 * @property userId Identificador do usuário logado (value object [UserId])
 * @property tenantId Identificador do tenant em contexto (value object [TenantId])
 * @property perfil Perfil funcional do usuário (ex: ADMIN, MÉDICO, PACIENTE)
 * @property contexto Contexto técnico da sessão (plano, permissões, recursos, etc.)
 */
data class SessaoUsuario(
    val userId: UserId,
    val tenantId: TenantId,
    val perfil: PerfilUsuario,
    val contexto: ContextoSessao
) : Serializable
