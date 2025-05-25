package com.pluranex.api_consulta_saas.domain.enums.profissional

enum class TipoVinculoProfissional(val descricao: String) {
    EFETIVO("Efetivo da clínica"),
    COLABORADOR("Colaborador externo"),
    TERCEIRIZADO("Profissional terceirizado"),
    CONVIDADO("Convidado eventual");

    override fun toString(): String = descricao
}
