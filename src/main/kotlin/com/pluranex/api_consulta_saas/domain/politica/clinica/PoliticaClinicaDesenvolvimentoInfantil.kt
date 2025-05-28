package com.pluranex.api_consulta_saas.domain.politica.clinica

import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento
import org.springframework.stereotype.Component

/**
 * Política específica para clínicas de Desenvolvimento Infantil.
 *
 * Essa política define:
 * - Quais procedimentos estão habilitados para essa clínica.
 * - Se exige responsável legal para o paciente.
 * - O tipo de ficha de anamnese padrão.
 *
 * Aplicável apenas a clínicas cujo perfil seja voltado ao público infantil.
 */
@Policy(name = NomePolitica.INFANTIL, type = TipoPolitica.CLINICA)
@Component
class PoliticaClinicaDesenvolvimentoInfantil : ClinicaPolicy {

    /**
     * Define se é obrigatório o vínculo de um responsável legal ao paciente.
     *
     * Para clínicas infantis, sempre retorna true.
     */
    override fun exigeResponsavelLegal(clinica: Clinica, paciente: Paciente): Boolean = true


}
