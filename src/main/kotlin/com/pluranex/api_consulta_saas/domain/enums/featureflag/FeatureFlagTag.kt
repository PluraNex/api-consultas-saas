package com.pluranex.api_consulta_saas.domain.featureflag.enums

/**
 * Enumeração que define **categorias funcionais** atribuídas a Feature Flags.
 *
 * As tags são utilizadas para organizar, filtrar e documentar funcionalidades
 * experimentais ou condicionais dentro do sistema.
 *
 * ### Finalidades:
 * - Agrupar flags por área funcional (UX, IA, Pagamento, etc.)
 * - Melhorar a legibilidade em logs, admins e documentação
 * - Permitir filtros semânticos nos painéis de gerenciamento de flags
 *
 * @property descricao Descrição legível da categoria
 */
enum class FeatureFlagTag(val descricao: String) {

    /** Funcionalidades relacionadas ao fluxo de agendamento de consultas ou eventos. */
    AGENDAMENTO("Funcionalidades de agendamento"),

    /** Melhorias na experiência do usuário e na interface visual (UI/UX). */
    UX("Melhorias de experiência do usuário"),

    /** Funcionalidades de machine learning, automação ou algoritmos inteligentes. */
    IA("Recursos de inteligência artificial"),

    /** Recursos de videochamada, teleconsulta ou comunicação visual. */
    VIDEOCHAMADA("Recursos de vídeo"),

    /** Fluxos de cobrança, faturas e integrações com gateways de pagamento. */
    PAGAMENTO("Fluxos de cobrança ou pagamento"),

    /** Funcionalidades voltadas para gestão e administração da plataforma. */
    ADMIN("Configurações administrativas");

    /**
     * Retorna a descrição como representação textual da tag.
     */
    override fun toString(): String = descricao

    companion object {
        /**
         * Converte uma string em uma [FeatureFlagTag], ignorando capitalização.
         *
         * @param valor Nome da tag (ex: "IA", "agendamento")
         * @return A tag correspondente ou `null` se não encontrada
         */
        fun fromString(valor: String): FeatureFlagTag? =
            entries.firstOrNull { it.name.equals(valor, ignoreCase = true) }
    }
}
