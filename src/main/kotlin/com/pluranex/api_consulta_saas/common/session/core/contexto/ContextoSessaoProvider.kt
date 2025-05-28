package com.pluranex.api_consulta_saas.common.session.core.contexto

import com.pluranex.api_consulta_saas.common.session.core.ContextoSessao
import com.pluranex.api_consulta_saas.common.session.enums.EspecialidadeUsuario
import com.pluranex.api_consulta_saas.common.session.enums.ParametroSistema
import com.pluranex.api_consulta_saas.common.types.parametro.ParametrosSistema
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext

/**
 * Componente escopado por requisição que provê o [ContextoSessao] com os dados
 * necessários para a avaliação de regras de negócio, permissões, políticas,
 * perfil da clínica e recursos contratados.
 *
 * Este contexto é carregado automaticamente e disponível via injeção durante o ciclo da requisição.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class ContextoSessaoProvider : ContextoSessao(
    permissoes = fornecerPermissoesAtivas(),
    parametros = fornecerParametrosSistema(),
    plano = fornecerPlanoContratado(),
    especialidadesUsuario = fornecerEspecialidadesUsuario(),
    perfilClinica = fornecerPerfilClinica()
) {
    companion object {

        private fun fornecerPermissoesAtivas(): PermissoesAtivas =
            PermissoesAtivas(setOf(/* TODO: buscar permissões do usuário logado */))

        private fun fornecerParametrosSistema(): ParametrosSistema =
            ParametrosSistema(
                mapOf(
                    ParametroSistema.WHATSAPP_ATIVO to "true",
                    ParametroSistema.LIMITE_PACIENTES_ATIVOS to "1000"
                    // TODO: carregar de fonte real (config service, banco, etc.)
                )
            )

        private fun fornecerPlanoContratado(): PlanoContratado =
            PlanoContratado.doPlano(PlanoTenant.PRO) // TODO: buscar do tenant atual

        private fun fornecerEspecialidadesUsuario(): List<EspecialidadeUsuario> =
            listOf() // TODO: carregar especialidades do usuário autenticado

        private fun fornecerPerfilClinica(): PerfilClinica =
            PerfilClinica.DESENVOLVIMENTO_INFANTIL // TODO: resolver pelo tenant/contexto
    }
}
