package com.pluranex.api_consulta_saas.domain.exceptions

/**
 * Exceções relacionadas à autenticação e segurança de sessão.
 *
 * Usada para erros envolvendo token JWT, perfil do usuário e autenticação da sessão.
 */
class AuthException(
    val type: AuthExceptionType,
    override val message: String? = null,
    cause: Throwable? = null
) : RuntimeException("[${type.code()}] $message", cause) {

    val errorCode: String = type.code()

    enum class AuthExceptionType(val code: Int, val message: String) {

        /** Token JWT inválido ou malformado */
        TOKEN_INVALIDO(1, "Token JWT inválido."),

        /** Token JWT expirado */
        TOKEN_EXPIRADO(2, "Token JWT expirado."),

        /** Token ausente no header Authorization */
        TOKEN_AUSENTE(3, "Token JWT ausente no header Authorization."),

        /** Falha ao converter o conteúdo do token em uma sessão válida */
        ERRO_DESSERIALIZAR_SESSAO(4, "Erro ao desserializar os dados da sessão."),

        /** Usuário autenticado não possui um perfil válido */
        PERFIL_INVALIDO(5, "Perfil do usuário inválido ou corrompido."),

        /** Nenhuma sessão de usuário autenticado encontrada */
        USUARIO_NAO_AUTENTICADO(6, "Usuário não autenticado ou sessão ausente."),

        /** Falha genérica no processo de autenticação */
        FALHA_AUTENTICACAO(7, "Falha geral na autenticação.");

        fun code() = "AUTH-%03d".format(code)
    }
}
