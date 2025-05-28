package com.pluranex.api_consulta_saas.domain.enums.politica

/**
 * Enumeração que representa os tipos possíveis de políticas (Policy)
 * aplicáveis ao domínio da aplicação.
 *
 * Usada para categorizar implementações da anotação [@Policy],
 * facilitando a identificação e aplicação de regras específicas.
 */
enum class TipoPolitica(val descricao: String) {
    CLINICA("Política Clínica"),
    PACIENTE("Política de Paciente"),
    AGENDAMENTO("Política de Agendamento"),
    FINANCEIRO("Política Financeira"),
    CONSENTIMENTO("Política de Consentimento"),
    PROCEDIMENTO("Política de Procedimento");

    override fun toString(): String = descricao
}
