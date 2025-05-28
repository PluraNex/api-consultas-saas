package com.pluranex.api_consulta_saas.domain.politica.clinica

import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.paciente.Paciente
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento

/**
 * Define o contrato para regras de negócio específicas aplicáveis a uma [Clinica],
 * permitindo personalização de comportamento clínico com base no contexto da unidade.
 *
 * Essa interface permite múltiplas implementações com variação de lógica de negócio
 * entre diferentes clínicas, especialidades ou tenants. A resolução dinâmica é feita
 * via a [ClinicaPolicyFactory].
 */
interface ClinicaPolicy {

    /**
     * Define se um paciente da clínica precisa obrigatoriamente de responsável legal.
     *
     * Por exemplo: crianças em clínicas pediátricas ou desenvolvimento infantil.
     *
     * @param clinica Clínica na qual o paciente será atendido.
     * @param paciente Paciente que está sendo avaliado.
     * @return `true` se for exigido um responsável legal, `false` caso contrário.
     */
    fun exigeResponsavelLegal(clinica: Clinica, paciente: Paciente): Boolean

}
