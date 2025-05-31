package com.pluranex.api_consulta_saas.domain.procedimento.policy.service

import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessaoResolver
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.procedimento.policy.definition.ProcedimentoPolicy
import com.pluranex.api_consulta_saas.domain.procedimento.policy.factory.ProcedimentoPolicyFactory
import org.springframework.stereotype.Service

/**
 * Serviço de domínio que encapsula a lógica de aplicação das políticas
 * de procedimento, conforme o perfil da clínica atual da sessão.
 *
 * Permite validar permissões e consultar configurações específicas da política vigente.
 */
@Service
class ProcedimentoPolicyServiceImpl(
    private val procedimentoPolicyFactory: ProcedimentoPolicyFactory
) : ProcedimentoPolicyService {

    override fun tiposPermitidos(perfil: PerfilClinica): Set<TipoProcedimento> {
        return politicaPara(perfil).tiposPermitidos()
    }

    override fun verificarPermissaoTipoOuFalhar(tipo: TipoProcedimento, perfil: PerfilClinica) {
        if (tipo !in tiposPermitidos(perfil)) {
            throw IllegalArgumentException("O tipo de procedimento '$tipo' não é permitido para a clínica com perfil $perfil.")
        }
    }

    private fun politicaPara(perfil: PerfilClinica): ProcedimentoPolicy {
        return procedimentoPolicyFactory.resolver(perfil)
    }
}
