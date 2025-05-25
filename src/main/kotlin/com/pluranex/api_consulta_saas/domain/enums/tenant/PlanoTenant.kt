package com.pluranex.api_consulta_saas.domain.enums.plano

import com.pluranex.api_consulta_saas.domain.recurso.types.RecursoLimite
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Enum que representa os tipos de planos contratáveis por um tenant.
 *
 * Cada plano define permissões, limites e capacidades disponíveis para o cliente.
 */
enum class PlanoTenant(
    val descricao: String,
    val permiteIa: Boolean,
    val permiteVideo: Boolean,
    val limiteLicencas: Int
) {
    TRIAL("Período de teste", permiteIa = true, permiteVideo = false, limiteLicencas = 1),
    BASICO("Plano básico", permiteIa = false, permiteVideo = false, limiteLicencas = 3),
    PRO("Plano profissional", permiteIa = true, permiteVideo = true, limiteLicencas = 10),
    ENTERPRISE("Plano completo", permiteIa = true, permiteVideo = true, limiteLicencas = 99);

    /**
     * Retorna os recursos padrão contratados ao se ativar este plano.
     */
    fun recursosPadrao(): RecursosContratados = when (this) {
        TRIAL -> RecursosContratados(
            armazenamento = RecursoLimite(500, 0),
            envioSms = RecursoLimite(20, 0),
            envioEmails = RecursoLimite(50, 0),
            licencasUsuario = RecursoLimite(1, 0),
            videochamadas = null,
            inteligenciaArtificial = true,
            tokensIa = RecursoLimite(1000, 0)
        )

        BASICO -> RecursosContratados(
            armazenamento = RecursoLimite(2000, 0),
            envioSms = RecursoLimite(100, 0),
            envioEmails = RecursoLimite(200, 0),
            licencasUsuario = RecursoLimite(3, 0),
            videochamadas = null,
            inteligenciaArtificial = false,
            tokensIa = RecursoLimite(0, 0)
        )

        PRO -> RecursosContratados(
            armazenamento = RecursoLimite(10000, 0),
            envioSms = RecursoLimite(300, 0),
            envioEmails = RecursoLimite(1000, 0),
            licencasUsuario = RecursoLimite(10, 0),
            videochamadas = RecursoLimite(100, 0),
            inteligenciaArtificial = true,
            tokensIa = RecursoLimite(5000, 0)
        )

        ENTERPRISE -> RecursosContratados(
            armazenamento = RecursoLimite(50000, 0),
            envioSms = RecursoLimite(1000, 0),
            envioEmails = RecursoLimite(5000, 0),
            licencasUsuario = RecursoLimite(99, 0),
            videochamadas = RecursoLimite(1000, 0),
            inteligenciaArtificial = true,
            tokensIa = RecursoLimite(20000, 0)
        )
    }
}
