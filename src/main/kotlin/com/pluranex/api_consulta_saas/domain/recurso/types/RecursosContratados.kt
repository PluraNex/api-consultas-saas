package com.pluranex.api_consulta_saas.domain.recurso.types

import com.pluranex.api_consulta_saas.domain.enums.recurso.TipoRecurso

/**
 * Value Object que representa todos os recursos contratados por um cliente (tenant).
 *
 * Cada campo representa um limite operacional que pode ser consumido durante
 * o uso da plataforma. Este objeto é utilizado para controle de regras de plano,
 * billing, alertas e funcionalidades disponíveis por unidade contratante.
 */
data class RecursosContratados(
    val armazenamento: RecursoLimite,
    val envioSms: RecursoLimite,
    val envioEmails: RecursoLimite,
    val licencasUsuario: RecursoLimite,
    val videochamadas: RecursoLimite?,
    val inteligenciaArtificial: Boolean,
    val tokensIa: RecursoLimite
) {
    companion object {

        /**
         * Instância padrão com todos os recursos zerados ou desativados.
         */
        fun vazio() = RecursosContratados(
            armazenamento = RecursoLimite(0, 0),
            envioSms = RecursoLimite(0, 0),
            envioEmails = RecursoLimite(0, 0),
            licencasUsuario = RecursoLimite(0, 0),
            videochamadas = null,
            inteligenciaArtificial = false,
            tokensIa = RecursoLimite(0, 0)
        )

        /**
         * Cria uma instância de [RecursosContratados] a partir de um mapeamento enum → valor contratado.
         *
         * @param recursos Lista de pares (TipoRecurso → contratado).
         * @param inteligenciaArtificial Define se o plano tem IA ativada.
         */
        fun of(
            vararg recursos: Pair<TipoRecurso, Int>,
            inteligenciaArtificial: Boolean = false
        ): RecursosContratados {
            val mapa = recursos.toMap()
            return RecursosContratados(
                armazenamento = RecursoLimite(mapa[TipoRecurso.ARMAZENAMENTO] ?: 0, 0),
                envioSms = RecursoLimite(mapa[TipoRecurso.ENVIO_SMS] ?: 0, 0),
                envioEmails = RecursoLimite(mapa[TipoRecurso.ENVIO_EMAILS] ?: 0, 0),
                licencasUsuario = RecursoLimite(mapa[TipoRecurso.LICENCAS_USUARIO] ?: 0, 0),
                videochamadas = mapa[TipoRecurso.VIDEOCHAMADAS]?.let { RecursoLimite(it, 0) },
                tokensIa = RecursoLimite(mapa[TipoRecurso.TOKENS_IA] ?: 0, 0),
                inteligenciaArtificial = inteligenciaArtificial
            )
        }
    }
}
