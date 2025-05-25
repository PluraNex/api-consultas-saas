package com.pluranex.api_consulta_saas.domain.permissao

import com.pluranex.api_consulta_saas.domain.enums.permissao.EscopoPermissao
import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao
import java.time.LocalDateTime

/**
 * Representa uma permissão atribuída a um usuário dentro do sistema.
 *
 * Essa estrutura é utilizada para associar dinamicamente permissões
 * ao usuário com informações adicionais como escopo, origem e data de atribuição.
 *
 * @property permissao Enum que define a permissão específica atribuída ao usuário
 * @property escopo Escopo de validade da permissão (LOCAL, GLOBAL, MODULO)
 * @property atribuidaPor Identificador do usuário ou sistema que atribuiu essa permissão
 * @property atribuidaEm Data e hora em que a permissão foi concedida
 */
data class PermissaoUsuario(
    val permissao: Permissao,
    val escopo: EscopoPermissao = EscopoPermissao.LOCAL,
    val atribuidaPor: String? = null,
    val atribuidaEm: LocalDateTime = LocalDateTime.now()
)
