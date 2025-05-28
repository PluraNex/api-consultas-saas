package com.pluranex.api_consulta_saas.domain.enums.procedimento

/**
 * Representa categorias amplas de procedimentos clínicos realizados na clínica.
 * Usada para organizar e aplicar regras de negócio por tipo de procedimento.
 *
 * @property descricao Descrição amigável para exibição em telas e relatórios.
 */
enum class CategoriaProcedimento(val descricao: String) {
    CONSULTA("Consulta e Avaliação"),
    TERAPIA("Terapias"),
    EXAME("Exames e Testes"),
    RELATORIO("Relatórios e Documentos"),
    ADMINISTRATIVO("Administrativo"),
    FINANCEIRO("Financeiro"),
    OUTRO("Outro");

    override fun toString(): String = descricao
}
