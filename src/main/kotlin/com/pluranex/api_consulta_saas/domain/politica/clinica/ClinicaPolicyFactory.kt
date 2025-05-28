package com.pluranex.api_consulta_saas.domain.politica.clinica


import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.clinica.Clinica
import com.pluranex.api_consulta_saas.domain.enums.clinica.EspecialidadeClinica
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import org.springframework.stereotype.Component

/**
 * Fábrica responsável por resolver dinamicamente a implementação de [ClinicaPolicy]
 * apropriada para uma determinada clínica, com base nas especialidades registradas
 * e nas anotações de metadados fornecidas via [@Policy].
 *
 * A resolução segue a seguinte lógica:
 * - Se a clínica possuir especialidades compatíveis com a política infantil,
 *   e existir uma política anotada como `@Policy(name = INFANTIL, type = CLINICA)`,
 *   ela será retornada.
 * - Caso contrário, a política anotada como `DEFAULT` será usada.
 *
 * Essa abordagem permite que políticas específicas sejam plugadas e priorizadas
 * sem necessidade de alterar a lógica da fábrica.
 *
 * @param politicas Lista de políticas clínicas disponíveis injetadas automaticamente pelo Spring.
 */
@Component
class ClinicaPolicyFactory(
    private val politicas: List<ClinicaPolicy>
) {

    fun resolver(clinica: Clinica): ClinicaPolicy {
        val perfil = clinica.perfil

        // Tenta encontrar uma política registrada com o nome igual ao perfil da clínica
        val politicaCorrespondente = politicas.find { politica ->
            val anotacao = politica::class.java.getAnnotation(Policy::class.java)
            anotacao?.type == TipoPolitica.CLINICA &&
                    anotacao.name == when (perfil) {
                PerfilClinica.DESENVOLVIMENTO_INFANTIL -> NomePolitica.INFANTIL
                PerfilClinica.MULTIDISCIPLINAR -> NomePolitica.MULTIDISCIPLINAR
                else -> NomePolitica.DEFAULT
            }
        }

        return politicaCorrespondente ?: politicas.find {
            it::class.java.getAnnotation(Policy::class.java)?.name == NomePolitica.DEFAULT
        } ?: throw IllegalStateException("Nenhuma política clínica aplicável encontrada.")
    }
}
