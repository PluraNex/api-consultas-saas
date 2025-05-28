package com.pluranex.api_consulta_saas.domain.politica.shared

import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessao
import com.pluranex.api_consulta_saas.domain.politica.clinica.ClinicaPolicy
import com.pluranex.api_consulta_saas.domain.politica.clinica.ClinicaPolicyFactory
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento
import org.springframework.stereotype.Component

@Component
class ResolvedPolicyProvider(
    private val contextoSessao: ContextoSessao,
    private val clinicaPolicyFactory: ClinicaPolicyFactory
) {
    fun clinicaPolicy(): ClinicaPolicy {
        return clinicaPolicyFactory.resolver(contextoSessao.perfilClinica)
    }

    fun procedimentoPermitido(procedimento: Procedimento): Boolean {
        return clinicaPolicy().permiteProcedimento(contextoSessao.perfilClinica, procedimento)
    }

    fun exigeResponsavelLegal(paciente: Paciente): Boolean {
        return clinicaPolicy().exigeResponsavelLegal(contextoSessao.perfilClinica, paciente)
    }
}