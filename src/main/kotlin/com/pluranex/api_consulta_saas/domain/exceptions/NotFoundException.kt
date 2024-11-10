package com.pluranex.api_consulta_saas.domain.exceptions

open class NotFoundException constructor(
    exceptionType: NotFoundExceptionType,
    override val message: String? = null
) : RuntimeException("[${exceptionType.code()}] $message") {

    val errorCode: String = exceptionType.code()

    enum class NotFoundExceptionType(val code: Int, val message: String) {

        // Paciente

        PACIENTE_NOT_FOUND(1, "Paciente não encontrado."),
        PACIENTE_UPDATE_NOT_FOUND(2, "Paciente não encontrado para atualização."),

        // Profissional

        PROFISSIONAL_NOT_FOUND(3, "Profissional não encontrado."),
        PROFISSIONAL_UPDATE_NOT_FOUND(4, "Profissional não encontrado para atualização."),

        // Consulta

        CONSULTA_NOT_FOUND(5, "Consulta não encontrada."),
        CONSULTA_UPDATE_NOT_FOUND(6, "Consulta não encontrada para atualização."),

        // Notificação

        NOTIFICACAO_NOT_FOUND(7, "Notificação não encontrada."),
        NOTIFICACAO_UPDATE_NOT_FOUND(8, "Notificação não encontrada para atualização.");

        fun code() = "NOT-%03d".format(code)
    }
}
