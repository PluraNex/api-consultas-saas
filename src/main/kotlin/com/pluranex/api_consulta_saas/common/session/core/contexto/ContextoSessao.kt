package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.common.session.enums.EspecialidadeUsuario
import com.pluranex.api_consulta_saas.common.types.parametro.ParametrosSistema
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Representa o contexto técnico-operacional da sessão atual do usuário.
 *
 * Inclui permissões, parâmetros, especialidades e o plano contratado.
 * Serve como base para decisões de autorização, habilitação de recursos e validações de negócio.
 *
 * ### Responsabilidades:
 * - Indicar permissões ativas
 * - Expor o plano contratado e os recursos disponíveis
 * - Fornecer parâmetros de configuração e especialidades do usuário
 */
open data class ContextoSessao(
    val permissoes: PermissoesAtivas,
    val parametros: ParametrosSistema,
    val plano: PlanoContratado,
    val especialidadesUsuario: List<EspecialidadeUsuario>,
    val perfilClinica: PerfilClinica

) {
    /**
     * Acesso direto aos recursos contratados pelo tenant da sessão.
     */
    val recursos: RecursosContratados get() = plano.recursos

    /**
     * Tipo de plano contratado (TRIAL, PRO, etc.).
     */
    val tipoPlano get() = plano.tipo
}