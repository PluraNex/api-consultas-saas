package com.pluranex.api_consulta_saas.domain.exceptions

open class BusinessException constructor(
    exceptionType: BusinessExceptionType,
    override val message: String? = null
) : RuntimeException("[${exceptionType.code()}] $message") {

    val errorCode: String = exceptionType.code()

    enum class BusinessExceptionType(val code: Int, val message: String) {
        // Exceções relacionadas a consultas

        HORARIO_INDISPONIVEL(1, "Horário indisponível para agendamento de consulta."),
        CONSULTA_JA_CONFIRMADA(2, "A consulta já foi confirmada e não pode ser alterada."),
        CONSULTA_JA_CANCELADA(3, "A consulta já foi cancelada e não pode ser reagendada."),
        CONSULTA_FINALIZADA(4, "A consulta já foi finalizada e não pode ser modificada."),

        // Exceções relacionadas a pacientes

        PACIENTE_INATIVO(5, "Paciente está inativo e não pode ser atualizado."),
        EMAIL_DUPLICADO(6, "O e-mail fornecido já está em uso por outro paciente."),

        // Exceções relacionadas a profissionais

        PROFISSIONAL_INATIVO(7, "Profissional está inativo e não pode ser alocado."),
        ESPECIALIDADE_NAO_SUPORTADA(8, "Especialidade do profissional não é suportada para esta consulta."),

        // Exceções relacionadas a notificações

        NOTIFICACAO_JA_ENVIADA(9, "A notificação já foi enviada e não pode ser reenviada."),
        TIPO_NOTIFICACAO_INVALIDO(10, "Tipo de notificação inválido para o contexto atual."),
        DESTINATARIO_INVALIDO(11, "O destinatário da notificação é inválido ou não pode ser encontrado."),
        LIMITE_ENVIO_EXCEDIDO(12, "O limite de envio de notificações foi excedido."),
        NOTIFICACAO_PENDENTE(13, "A notificação ainda está pendente e não pode ser alterada."),
        FALHA_NO_ENVIO(14, "Falha no envio da notificação. Tente novamente mais tarde."),
        FALHA_NO_REENVIO(15, "Falha no reenvio da notificação."),
        CANAL_NAO_SUPORTADO(16, "O canal de notificação não é suportado."),

        // Exceções relacionadas à configuração de notificação

        CONFIGURACAO_INVALIDA(17, "A configuração da notificação é inválida."),
        NOTIFICACAO_AUSENTE_PARA_CONFIGURACAO(18, "A notificação está ausente para a configuração solicitada."),
        CONFIGURACAO_EM_USO(19, "A configuração de notificação está em uso e não pode ser removida."),

        // Nova exceção adicionada para validação de canal ativo

        CANAL_NAO_ATIVO_NA_CONFIGURACAO(20, "O canal de notificação não está ativo na configuração atual."),

        // Exceções relacionadas a empresas de saúde
        EMPRESA_NOME_INVALIDO(21, "O nome da empresa de saúde é inválido.");
        fun code() = "BUS-%03d".format(code)
    }
}
