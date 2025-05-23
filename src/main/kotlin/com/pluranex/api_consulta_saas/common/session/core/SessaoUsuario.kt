package common.session.core

import com.pluranex.api_consulta_saas.common.session.core.ContextoSessao
import com.pluranex.api_consulta_saas.common.session.core.PerfilUsuario
import java.io.Serializable

/**
 * Representa o contexto completo de uma sessão autenticada no sistema.
 *
 * Esta estrutura é derivada do token JWT ou de cabeçalhos HTTP e utilizada para
 * injeção contextual via `@RequestScope`, fornecendo as informações necessárias
 * para autorização e comportamento de negócio baseado em sessão.
 *
 * @property userId Identificador único do usuário autenticado
 * @property tenantId Código do tenant (empresa/clínica) ativo
 * @property perfil Dados do perfil ativo do usuário
 * @property contexto Informações contextuais como permissões, especialidades e recursos
 */
data class SessaoUsuario(
    val userId: String,
    val tenantId: String,
    val perfil: PerfilUsuario,
    val contexto: ContextoSessao
)