package com.pluranex.api_consulta_saas.domain.politica.paciente

import com.pluranex.api_consulta_saas.common.types.identidade.Sexo
import com.pluranex.api_consulta_saas.domain.enums.sexo.TipoDeSexo

/**
 * Define regras de negócio relacionadas ao uso de identidade de gênero
 * em contextos clínicos e administrativos, com base em configurações
 * específicas do tenant ou cenário de uso.
 */
interface SexoPolicy {

    /**
     * Retorna os tipos permitidos para o tenant atual.
     */
    fun tiposPermitidos(): Set<TipoDeSexo>

    /**
     * Verifica se um sexo está autorizado para uso no contexto atual.
     */
    fun isPermitido(sexo: Sexo): Boolean = sexo.value in tiposPermitidos()

    /**
     * Verifica se o sexo deve ser ocultado em contextos sensíveis.
     */
    fun deveOcultarParaTela(sexo: Sexo): Boolean

    /**
     * Valida se o sexo informado pode ser usado para um tipo de atendimento.
     */
    fun podeSerUsadoEm(atendimento: TipoDeAtendimento, sexo: Sexo): Boolean
}