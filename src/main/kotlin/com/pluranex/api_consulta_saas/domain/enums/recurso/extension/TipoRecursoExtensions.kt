package com.pluranex.api_consulta_saas.domain.enums.recurso.extension

import com.pluranex.api_consulta_saas.domain.enums.recurso.TipoRecurso
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursoLimite
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Extensões utilitárias para o enum [TipoRecurso].
 *
 * Permite extrair dinamicamente o recurso correspondente de uma instância de [RecursosContratados],
 * garantindo reutilização e evitando duplicação de lógica.
 *
 * ### Exemplo de uso:
 * ```
 * val recurso = TipoRecurso.ENVIO_SMS.extrairDe(recursosContratados)
 * if (recurso.estahDisponivel(5)) {
 *     println("Recurso suficiente!")
 * }
 * ```
 *
 * @receiver Tipo do recurso desejado.
 * @param recursos Instância de [RecursosContratados] da qual extrair o recurso.
 * @return Instância de [RecursoLimite] correspondente ao tipo.
 */
fun TipoRecurso.extrairDe(recursos: RecursosContratados): RecursoLimite = when (this) {
    TipoRecurso.ARMAZENAMENTO     -> recursos.armazenamento
    TipoRecurso.ENVIO_SMS         -> recursos.envioSms
    TipoRecurso.ENVIO_EMAILS      -> recursos.envioEmails
    TipoRecurso.LICENCAS_USUARIO  -> recursos.licencasUsuario
    TipoRecurso.VIDEOCHAMADAS     -> recursos.videochamadas ?: RecursoLimite(0, 0)
    TipoRecurso.TOKENS_IA         -> recursos.tokensIa
}
