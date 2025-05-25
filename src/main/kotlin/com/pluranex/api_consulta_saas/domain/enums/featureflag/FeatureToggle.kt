package com.pluranex.api_consulta_saas.domain.enums.featureflag

import com.pluranex.api_consulta_saas.domain.enums.usuario.PerfilUsuario
import com.pluranex.api_consulta_saas.domain.featureflag.enums.FeatureFlagTag

/**
 * Enum que representa todas as funcionalidades controladas por feature flag no sistema.
 *
 * Cada valor corresponde a uma funcionalidade que pode ser ativada/desativada dinamicamente,
 * com base em escopos como tenant, perfil ou usuário.
 *
 * ### Convenções:
 * - O nome da flag deve ser técnico e único no sistema.
 * - A descrição deve ser clara para uso em painel administrativo ou logs.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * if (featureService.estaHabilitada(FeatureToggle.NOVA_TELA_AGENDAMENTO)) { ... }
 * ```
 *
 * @property descricao Descrição funcional da feature (visível no painel de gerenciamento)
 * @property tags Tags ou categorias associadas à feature (ex: "UX", "AGENDAMENTO", "IA")
 * @property perfilPadrao Perfil funcional para o qual a feature é mais relevante (opcional)
 */
enum class FeatureToggle(
    val descricao: String,
    val tags: Set<FeatureFlagTag> = emptySet(),
    val perfilPadrao: PerfilUsuario? = null
) {
    NOVA_TELA_AGENDAMENTO(
        descricao = "Nova experiência de agendamento com drag-and-drop",
        tags = setOf(FeatureFlagTag.UX, FeatureFlagTag.AGENDAMENTO),
        perfilPadrao = PerfilUsuario.ATENDENTE
    ),

    DASHBOARD_INTELIGENTE(
        descricao = "Dashboard com análise preditiva e IA",
        tags = setOf(FeatureFlagTag.IA),
        perfilPadrao = PerfilUsuario.MASTER
    ),

    VIDEOCHAMADA_SEGURA(
        descricao = "Nova implementação de videoconferência segura",
        tags = setOf(FeatureFlagTag.VIDEOCHAMADA),
        perfilPadrao = PerfilUsuario.MEDICO
    ),

    FLUXO_PAGAMENTO_INTEGRADO(
        descricao = "Checkout com gateway de pagamento nativo",
        tags = setOf(FeatureFlagTag.PAGAMENTO),
        perfilPadrao = PerfilUsuario.ADMIN
    );
}