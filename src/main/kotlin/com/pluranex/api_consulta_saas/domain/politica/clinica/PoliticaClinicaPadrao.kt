package com.pluranex.api_consulta_saas.domain.politica.clinica

import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento
import org.springframework.stereotype.Component

/**
 * Política padrão aplicada às clínicas que não possuem uma especialização específica.
 *
 * Esta política:
 * - Permite todos os procedimentos do sistema.
 * - Não exige responsável legal para o paciente, por padrão.
 * - Utiliza ficha de anamnese padrão (geral).
 */
@Policy(name = NomePolitica.DEFAULT, type = TipoPolitica.CLINICA)
@Component
class PoliticaClinicaPadrao : ClinicaPolicy {

    /**
     * Define se é obrigatório o vínculo de um responsável legal ao paciente.
     *
     * Por padrão, clínicas gerais não exigem responsável legal.
     */
    override fun exigeResponsavelLegal(clinica: Clinica, paciente: Paciente): Boolean = false

}
