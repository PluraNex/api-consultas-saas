package com.pluranex.api_consulta_saas.common.types.tenant.vo

/**
 * Value Object que representa os recursos funcionais contratados por um tenant (cliente da plataforma).
 *
 * Essa estrutura define os limites e capacidades ativas para um tenant, sendo usada para controle
 * operacional de funcionalidades como envio de mensagens, uso de IA, vídeo e licenciamento.
 *
 * Os valores representam o que foi contratado e o que já foi consumido, permitindo verificações
 * como esgotamento de recursos ou necessidade de upgrade de plano.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * if (recursos.envioSms.estaEsgotado()) {
 *     throw LimiteExcedidoException("Seu limite de SMS foi atingido.")
 * }
 *
 * if (recursos.inteligenciaArtificial && recursos.tokensIa.restante() > 0) {
 *     iaService.gerarResposta()
 * }
 * ```
 *
 * @property armazenamento Limite de armazenamento em megabytes (ex: para arquivos ou imagens).
 * @property envioSms Limite de envio de mensagens SMS por ciclo (mensal, por exemplo).
 * @property envioEmails Limite de e-mails transacionais e de campanha.
 * @property licencasAtivas Número de licenças de usuário (ex: médicos, secretários) permitidas simultaneamente.
 * @property videochamadas Limite de sessões ou minutos de videochamadas (se suportado no plano).
 * @property inteligenciaArtificial Indica se o tenant tem acesso a recursos baseados em IA.
 * @property tokensIa Tokens de uso de IA (ex: GPT, diagnósticos, geração automática).
 */
data class RecursosContratados(
    val armazenamento: RecursoLimite,
    val envioSms: RecursoLimite,
    val envioEmails: RecursoLimite,
    val licencasAtivas: Int,
    val videochamadas: RecursoLimite?,
    val inteligenciaArtificial: Boolean,
    val tokensIa: RecursoLimite
) {

    companion object {
        /**
         * Cria uma instância padrão com todos os recursos zerados ou desabilitados.
         *
         * Essa função é usada como fallback para tenants recém-criados (ex: TRIAL)
         * ou quando os limites ainda não foram configurados pelo plano.
         */
        fun vazio() = RecursosContratados(
            armazenamento = RecursoLimite(0, 0),
            envioSms = RecursoLimite(0, 0),
            envioEmails = RecursoLimite(0, 0),
            licencasAtivas = 0,
            videochamadas = null,
            inteligenciaArtificial = false,
            tokensIa = RecursoLimite(0, 0)
        )
    }
}
