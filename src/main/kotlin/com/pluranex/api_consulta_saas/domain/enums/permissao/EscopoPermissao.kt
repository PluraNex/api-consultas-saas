package com.pluranex.api_consulta_saas.domain.enums.permissao

/**
 * Define o escopo de atuação de uma permissão dentro do sistema.
 *
 * Esse enum é usado para qualificar o alcance da permissão atribuída,
 * permitindo uma granularidade maior na definição de acessos.
 *
 * - `LOCAL`: A permissão se aplica apenas ao contexto do tenant atual.
 * - `GLOBAL`: A permissão é válida em todos os contextos, sem restrição de tenant.
 * - `MODULO`: A permissão é restrita a um módulo funcional específico.
 */
enum class EscopoPermissao {
    LOCAL,
    GLOBAL,
    MODULO
}
