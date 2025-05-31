package com.pluranex.api_consulta_saas.common.types.permissao

import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao


/**
 * Value Object que encapsula o conjunto de permissões ativas na sessão do usuário.
 *
 * Esta classe é usada no [ContextoSessao] para representar de forma segura e expressiva
 * as permissões habilitadas para a identidade logada, evitando manipulação direta de enums crus.
 *
 * ### Responsabilidades:
 * - Verificar presença de permissões específicas ou múltiplas
 * - Facilitar o controle de acesso em regras de negócio
 * - Expôr utilitários para verificação de papéis funcionais comuns (ex: admin, gestor)
 *
 * ### Exemplo de uso:
 * ```kotlin
 * if (sessao.contexto.permissoes.contem(Permissao.CRIAR_CONSULTA)) { ... }
 * if (sessao.contexto.permissoes.isAdmin()) { ... }
 * ```
 *
 * @property value Conjunto imutável de permissões ativas
 */
@JvmInline
value class PermissoesAtivas(val value: Set<Permissao>) {

    /**
     * Verifica se a permissão especificada está presente no conjunto ativo.
     */
    fun contem(permissao: Permissao): Boolean = value.contains(permissao)

    /**
     * Verifica se todas as permissões especificadas estão presentes.
     */
    fun contemTodas(vararg permissoes: Permissao): Boolean =
        permissoes.all { it in value }

    /**
     * Verifica se pelo menos uma das permissões especificadas está presente.
     */
    fun contemAlguma(vararg permissoes: Permissao): Boolean =
        permissoes.any { it in value }

    /**
     * Indica se não há nenhuma permissão ativa.
     */
    fun isVazio(): Boolean = value.isEmpty()

    /**
     * Indica se o usuário possui permissão de administrador global.
     */
    fun isAdmin(): Boolean = contem(Permissao.ADMINISTRAR_SISTEMA)

    /**
     * Indica se o usuário possui permissão de gestão de clínica.
     */
    fun isGestorClinica(): Boolean = contem(Permissao.GESTAO_CLINICA)

    /**
     * Retorna uma representação legível das permissões atuais.
     */
    override fun toString(): String = value.joinToString(", ") { it.name }

    companion object {
        /**
         * Cria uma instância a partir de uma lista ou conjunto de permissões.
         */
        fun of(vararg permissoes: Permissao): PermissoesAtivas = PermissoesAtivas(permissoes.toSet())

        fun fromLista(permissoes: List<Permissao>): PermissoesAtivas = PermissoesAtivas(permissoes.toSet())

        val vazio: PermissoesAtivas = PermissoesAtivas(emptySet())
    }
}
