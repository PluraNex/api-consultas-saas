package com.pluranex.api_consulta_saas.domain.exceptions

class PermissionException(
    exceptionType: PermissionExceptionType,
    override val message: String? = null
) : RuntimeException("[${exceptionType.code()}] $message") {

    val errorCode: String = exceptionType.code()

    enum class PermissionExceptionType(val code: Int, val message: String) {
        PERMISSAO_NEGADA(1, "Permissão negada para o recurso solicitado."),
        PERFIL_NAO_AUTORIZADO(2, "Perfil do usuário não possui autorização para esta ação."),
        TENANT_NAO_COMPATIVEL(3, "O tenant informado não é autorizado a executar esta operação.");

        fun code() = "PER-%03d".format(code)
    }
}
