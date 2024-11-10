package com.pluranex.api_consulta_saas.domain.exceptions

open class IntegrationException constructor(
    exceptionType: IntegrationExceptionType,
    override val message: String? = null
) : RuntimeException("[${exceptionType.code()}] $message") {
    val errorCode: String = exceptionType.code()

    enum class IntegrationExceptionType(val code: Int, val message: String) {
        // Erros relacionados a APIs externas
        API_EXTERNA_INDISPONIVEL(1, "Serviço externo indisponível."),
        TWILIO_API_ERROR(2, "Erro ao integrar com o serviço Twilio."),
        ERRO_AO_CRIAR_NOTIFICACAO(3, "Erro ao criar a notificação."),
        ERRO_AO_CRIAR_CONSULTA(4, "Erro ao criar a consulta."),
        ERRO_AO_REMOVER_NOTIFICACAO(5, "Erro ao remover notificação");

        fun code() = "INT-%03d".format(code)
    }
}
