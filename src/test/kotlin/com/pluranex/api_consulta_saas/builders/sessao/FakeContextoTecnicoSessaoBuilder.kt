package com.pluranex.api_consulta_saas.builders.sessao

import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoTecnicoSessao
import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario
import com.pluranex.api_consulta_saas.common.types.permissao.PermissoesAtivas
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

class FakeContextoTecnicoSessaoBuilder {

    private var permissoes: Set<Permissao> = setOf(Permissao.VISUALIZAR_CONSULTA)
    private var tipoPlano: PlanoTenant = PlanoTenant.TRIAL
    private var recursosContratados: RecursosContratados = RecursosContratados.vazio()
    private var especialidades: List<EspecialidadeAtuacaoUsuario> = listOf(EspecialidadeAtuacaoUsuario.PEDIATRIA)
    private var perfilClinica: PerfilClinica = PerfilClinica.DESENVOLVIMENTO_INFANTIL

    fun comPermissoes(vararg permissoes: Permissao) = apply {
        this.permissoes = permissoes.toSet()
    }

    fun comPlano(tipo: PlanoTenant, recursos: RecursosContratados = RecursosContratados.vazio()) = apply {
        this.tipoPlano = tipo
        this.recursosContratados = recursos
    }

    fun comEspecialidades(vararg especialidades: EspecialidadeAtuacaoUsuario) = apply {
        this.especialidades = especialidades.toList()
    }

    fun comPerfilClinica(perfil: PerfilClinica) = apply {
        this.perfilClinica = perfil
    }

    fun build(): ContextoTecnicoSessao {
        val permissoesAtivas = PermissoesAtivas(permissoes)
        val planoContratado = PlanoContratado(tipoPlano, recursosContratados)

        return object : ContextoTecnicoSessao() {
            override val permissoes = permissoesAtivas
            override val plano = planoContratado
            override val especialidadesUsuario = especialidades
            override val perfilClinica = this@FakeContextoTecnicoSessaoBuilder.perfilClinica
        }
    }
}
