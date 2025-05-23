package com.pluranex.api_consulta_saas.common.session.core

import com.pluranex.api_consulta_saas.common.session.enums.*
import com.pluranex.api_consulta_saas.common.types.parametro.ParametrosSistema
import com.pluranex.api_consulta_saas.common.types.permission.PermissoesAtivas

/**
 * Representa o contexto técnico-operacional da sessão atual do usuário,
 * incluindo permissões ativas, parâmetros do sistema e especialidades.
 *
 * Esta estrutura serve para controle fino de acesso e personalização de funcionalidades.
 *
 * @property permissoes Conjunto de permissões ativas para o usuário no sistema
 * @property parametros Parâmetros de sistema personalizados por tenant/perfil
 * @property recursos Informações sobre cotas de uso contratadas (SMS, emails, espaço)
 * @property especialidadesUsuario Especialidades atribuídas ao usuário logado
 */
data class ContextoSessao(
    val permissoes: PermissoesAtivas,
    val parametros: ParametrosSistema,
    val recursos: RecursosContratados,
    val especialidadesUsuario: List<EspecialidadeUsuario>
)
