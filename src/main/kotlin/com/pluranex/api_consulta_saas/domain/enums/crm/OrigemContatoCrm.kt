package com.pluranex.api_consulta_saas.domain.enums.crm

/**
 * Define a origem de um contato dentro do contexto de CRM.
 *
 * Essa informação ajuda a rastrear como o lead/cliente entrou na base,
 * sendo útil para estratégias de marketing, análise de conversão e atribuição de campanhas.
 *
 * ### Exemplos de uso:
 * - Exibir no painel de CRM de onde o cliente veio.
 * - Filtrar contatos por origem para campanhas segmentadas.
 */
enum class OrigemContatoCrm(val descricao: String) {

    /** Contato inserido manualmente pela equipe da clínica. */
    CADASTRO_MANUAL("Cadastro manual"),

    /** Contato adicionado via importação de planilha ou sistema externo. */
    IMPORTACAO("Importação de dados"),

    /** Lead vindo de formulário público no site ou página de captura. */
    FORMULARIO_SITE("Formulário do site"),

    /** Indicação realizada por outro paciente ou profissional. */
    INDICACAO("Indicação de terceiros"),

    /** Sincronização por API ou integração externa automatizada. */
    INTEGRACAO_EXTERNA("Integração externa");

    override fun toString(): String = descricao
}