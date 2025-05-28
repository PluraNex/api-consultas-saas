package com.pluranex.api_consulta_saas.domain.enums.politica

/**
 * Enumeração que representa os identificadores nomeados
 * para políticas de domínio aplicadas via anotação [@Policy].
 */
enum class NomePolitica(val id: String) {
    DEFAULT("default"),
    INFANTIL("infantil"),
    MULTIDISCIPLINAR("multidisciplinar"),
    FINANCEIRA_PADRAO("financeira-padrao");

    override fun toString(): String = id
}
