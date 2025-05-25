package com.pluranex.api_consulta_saas.domain.exceptions

open class IntegrationException constructor(
    exceptionType: IntegrationExceptionType,
    override val message: String? = null,
    cause: Throwable? = null
) : RuntimeException("[${exceptionType.code()}] $message", cause) {

    val errorCode: String = exceptionType.code()

    enum class IntegrationExceptionType(val code: Int, val message: String) {
        ERRO_INTEGRACAO_PROVEDOR_NOTIFICACAO(1, "Erro na integração com o provedor de notificação."),
        TWILIO_API_ERROR(2, "Erro ao integrar com o serviço Twilio."),
        ERRO_AO_CRIAR_NOTIFICACAO(3, "Erro ao criar a notificação."),
        ERRO_AO_CRIAR_CONSULTA(4, "Erro ao criar a consulta."),
        ERRO_AO_CRIAR_CONFIGURACAO(5, "Erro ao criar a configuração."),
        ERRO_AO_REMOVER_NOTIFICACAO(6, "Erro ao remover notificação."),
        ERRO_AO_LISTAR_NOTIFICACOES(7, "Erro ao listar notificações."),
        ERRO_AO_LISTAR_CONFIGURACOES(8, "Erro ao listar configurações."),
        ERRO_AO_ATUALIZAR_CONFIGURACAO(9, "Erro ao atualizar configuração"),
        ERRO_AO_ATUALIZAR_STATUS_NOTIFICACAO(9, "Erro ao atualizar status de notificação"),
        ERRO_AO_REMOVER_CONFIGURACAO(10, "Erro ao remover configuração"),
        ERRO_AO_BUSCAR_CONFIGURACAO(11, "Erro ao buscar configuração"),
        ERRO_AO_CRIAR_EMPRESA_SAUDE(12, "Erro ao criar a empresa de saúde."),
        ERRO_AO_LISTAR_EMPRESAS(12, "Erro ao listar empresas de saúde."),
        ERRO_AO_ATRIBUIR_PERMISSAO(13, "Erro ao atribuir permissão ao usuário."),
        ERRO_AO_SALVAR_FEATURE_FLAG(14, "Erro ao salvar o status da feature flag.");


        fun code() = "INT-%03d".format(code)
    }
}
