package com.pluranex.api_consulta_saas.common.annotations

import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import org.springframework.stereotype.Component

/**
 * Annotation para marcar classes como implementações de políticas de domínio,
 * permitindo que sejam descobertas e gerenciadas dinamicamente pelo sistema.
 *
 * Pode ser usada em políticas clínicas, de paciente, agendamento, financeiro, etc.
 *
 * ### Exemplo:
 * ```kotlin
 * @Policy(name = NomePolitica.DEFAULT, type = TipoPolitica.CLINICA)
 * class PoliticaClinicaPadrao : ClinicaPolicy
 * ```
 *
 * @property name Identificador único da política no domínio.
 * @property type Tipo de política (CLINICA, PACIENTE, AGENDAMENTO...).
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Policy(
    val name: NomePolitica,
    val type: TipoPolitica = TipoPolitica.CLINICA
)
