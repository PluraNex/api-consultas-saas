package com.pluranex.api_consulta_saas.common.session.core

import com.pluranex.api_consulta_saas.common.session.enums.TipoLicenca
import java.io.Serializable

/**
 * Representa os recursos contratados e disponíveis para o tenant atual (clínica).
 *
 * @property tipo Tipo da licença vigente (trial, premium, etc.)
 * @property armazenamento Cota de espaço em disco
 * @property envioSms Limite de SMS
 * @property envioEmails Limite de emails
 * @property licencasAtivas Número de licenças de usuários ativas
 * @property videochamadas Recursos de videoconferência
 * @property inteligenciaArtificial Flag que habilita uso de IA
 * @property tokensIa Cota de tokens de IA
 */
data class RecursosContratados(
    val tipo: TipoLicenca = TipoLicenca.BASICA,
    val armazenamento: RecursoLimite,
    val envioSms: RecursoLimite,
    val envioEmails: RecursoLimite,
    val licencasAtivas: Int,
    val videochamadas: RecursoLimite?,
    val inteligenciaArtificial: Boolean,
    val tokensIa: RecursoLimite


){
    companion object {
        fun vazio() = RecursosContratados(
            tipo = TipoLicenca.BASICA,
            armazenamento = RecursoLimite(0, 0),
            envioSms = RecursoLimite(0, 0),
            envioEmails = RecursoLimite(0, 0),
            licencasAtivas = 0,
            videochamadas = null,
            inteligenciaArtificial = false,
            tokensIa = RecursoLimite(0, 0)
        )
    }

}


