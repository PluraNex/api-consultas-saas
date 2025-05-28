package com.pluranex.api_consulta_saas.common.session.extensions

import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessao
import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica

/**
 * Extensões utilitárias para facilitar o uso do ContextoSessao.
 */

/**
 * Verifica se a clínica tem perfil de desenvolvimento infantil.
 */
fun ContextoSessao.isClinicaDesenvolvimentoInfantil(): Boolean =
    perfilClinica == PerfilClinica.DESENVOLVIMENTO_INFANTIL

/**
 * Verifica se a clínica é genérica (clínica geral ou multidisciplinar).
 */
fun ContextoSessao.isClinicaGenerica(): Boolean =
    perfilClinica in listOf(PerfilClinica.CLINICA_GERAL, PerfilClinica.MULTIDISCIPLINAR)

/**
 * Verifica se a clínica é do tipo geriatria.
 */
fun ContextoSessao.isClinicaGeriatrica(): Boolean =
    perfilClinica == PerfilClinica.GERIATRIA

/**
 * Verifica se o perfil da clínica é cardiologia.
 */
fun ContextoSessao.isClinicaCardiologica(): Boolean =
    perfilClinica == PerfilClinica.CARDIOLOGIA
