package com.pluranex.api_consulta_saas.domain.plano

import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.enums.recurso.TipoRecurso
import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Define os recursos padrão contratados para cada plano de tenant.
 *
 * Cada plano aponta para sua configuração inicial de recursos e permissões.
 */
object PlanoTenantRecursos {

    private val mapa: Map<PlanoTenant, RecursosContratados> = mapOf(
        PlanoTenant.TRIAL to RecursosContratados.of(
            TipoRecurso.ARMAZENAMENTO to 500,
            TipoRecurso.ENVIO_SMS to 20,
            TipoRecurso.ENVIO_EMAILS to 50,
            TipoRecurso.LICENCAS_USUARIO to 1,
            TipoRecurso.TOKENS_IA to 1000,
            inteligenciaArtificial = true
        ),
        PlanoTenant.BASICO to RecursosContratados.of(
            TipoRecurso.ARMAZENAMENTO to 2000,
            TipoRecurso.ENVIO_SMS to 100,
            TipoRecurso.ENVIO_EMAILS to 200,
            TipoRecurso.LICENCAS_USUARIO to 3,
            TipoRecurso.TOKENS_IA to 0,
            inteligenciaArtificial = false
        ),
        PlanoTenant.PRO to RecursosContratados.of(
            TipoRecurso.ARMAZENAMENTO to 10000,
            TipoRecurso.ENVIO_SMS to 300,
            TipoRecurso.ENVIO_EMAILS to 1000,
            TipoRecurso.LICENCAS_USUARIO to 10,
            TipoRecurso.VIDEOCHAMADAS to 100,
            TipoRecurso.TOKENS_IA to 5000,
            inteligenciaArtificial = true
        ),
        PlanoTenant.ENTERPRISE to RecursosContratados.of(
            TipoRecurso.ARMAZENAMENTO to 50000,
            TipoRecurso.ENVIO_SMS to 1000,
            TipoRecurso.ENVIO_EMAILS to 5000,
            TipoRecurso.LICENCAS_USUARIO to 99,
            TipoRecurso.VIDEOCHAMADAS to 1000,
            TipoRecurso.TOKENS_IA to 20000,
            inteligenciaArtificial = true
        )
    )

    fun recursosPadrao(plano: PlanoTenant): RecursosContratados =
        mapa[plano] ?: error("PlanoTenant não suportado: $plano")
}
