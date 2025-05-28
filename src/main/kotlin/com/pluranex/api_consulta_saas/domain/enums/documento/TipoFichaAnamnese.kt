package com.pluranex.api_consulta_saas.domain.enums.documento

/**
 * Representa os tipos lógicos de ficha clínica utilizados no sistema.
 *
 * Essas chaves são retornadas pelas políticas clínicas e utilizadas
 * para localizar o modelo de ficha correspondente no domínio de documentos.
 *
 * Este enum garante a separação entre regras clínicas e templates persistidos.
 */
enum class TipoFichaClinica(val descricao: String) {

    /** Ficha padrão para clínicas de desenvolvimento infantil. */
    INFANTIL("Ficha Infantil"),

    /** Ficha voltada ao atendimento psicológico (crianças ou adultos). */
    PSICOLOGICA("Ficha Psicológica"),

    /** Ficha básica para adultos em clínicas gerais. */
    ADULTO("Ficha Adulta"),

    /** Ficha especializada para intervenções ABA. */
    ABA("Ficha ABA"),

    /** Ficha usada para anamnese educacional ou psicopedagógica. */
    PSICOPEDAGOGICA("Ficha Psicopedagógica"),

    /** Ficha genérica usada como fallback. */
    DEFAULT("Ficha Genérica");

    override fun toString(): String = descricao
}
