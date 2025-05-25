package com.pluranex.api_consulta_saas.domain.tenant

import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.plano.types.PlanoContratado
import java.time.LocalDateTime

/**
 * Entidade que representa uma organização cliente da plataforma (ex: clínica ou consultório).
 *
 * Cada `Tenant` possui um ambiente isolado no sistema, com dados próprios, plano contratado
 * e identificação única via [TenantId]. A plataforma é multi-tenant por design.
 *
 * ### Responsabilidades:
 * - Representar a identidade institucional da unidade (código, nome, status).
 * - Gerenciar o plano contratado e os respectivos recursos.
 * - Controlar o ciclo de vida do trial, caso aplicável.
 *
 * ### Observações:
 * - O campo [expiracaoTrial] só tem efeito quando [plano.tipo] for `TRIAL`.
 * - A troca de plano deve ser feita exclusivamente via [atualizarPlano], garantindo coerência nos recursos.
 * - O campo [codigo] deve ser único e amigável para URLs ou subdomínios (ex: "clinica-vida").
 *
 * ### Exemplo de uso:
 * ```kotlin
 * if (tenant.trialExpirado()) {
 *     throw PlanoExpiradoException("Seu período de teste expirou.")
 * }
 * ```
 *
 * @property id Identificador interno do tenant (para persistência relacional).
 * @property tenantId Identificador técnico global para isolamento multi-tenant.
 * @property codigo Slug público legível e único (ex: usado como subdomínio ou identificador).
 * @property nome Nome fantasia ou razão social da organização.
 * @property ativo Indica se o tenant está com acesso habilitado à plataforma.
 * @property plano Plano contratado com tipo e recursos provisionados.
 * @property expiracaoTrial Data de término do período de avaliação gratuita, se houver.
 * @property criadoEm Data/hora de criação do registro.
 * @property atualizadoEm Data/hora da última modificação significativa.
 */
data class Tenant(
    val id: Long? = null,
    val tenantId: TenantId,
    val codigo: String,
    val nome: String,
    val ativo: Boolean = true,
    val plano: PlanoContratado,
    val expiracaoTrial: LocalDateTime? = LocalDateTime.now().plusDays(14),
    val criadoEm: LocalDateTime = LocalDateTime.now(),
    val atualizadoEm: LocalDateTime? = null
) {

    /**
     * Verifica se o tenant está em um período de avaliação ativo.
     */
    fun estaEmTrial(now: LocalDateTime = LocalDateTime.now()): Boolean =
        plano.tipo == PlanoTenant.TRIAL && expiracaoTrial?.isAfter(now) == true

    /**
     * Verifica se o período de trial já expirou.
     */
    fun trialExpirado(now: LocalDateTime = LocalDateTime.now()): Boolean =
        plano.tipo == PlanoTenant.TRIAL && expiracaoTrial?.isBefore(now) == true

    /**
     * Atualiza o plano do tenant e gera os recursos padrão associados ao novo plano.
     *
     * @param novoPlano Novo plano a ser contratado.
     * @return Nova instância do `Tenant` com plano atualizado.
     */
    fun atualizarPlano(novoPlano: PlanoTenant): Tenant =
        copy(plano = PlanoContratado.doPlano(novoPlano), atualizadoEm = LocalDateTime.now())
}
