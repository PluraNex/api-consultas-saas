package com.pluranex.api_consulta_saas.common.types.recurso

import com.pluranex.api_consulta_saas.domain.recurso.types.RecursosContratados

/**
 * Wrapper semântico que facilita o uso dos recursos contratados com métodos utilitários.
 *
 * Deve ser usado em contexto de sessão e regras de ativação de funcionalidades.
 *
 * Para adicionar novos recursos:
 * - Inclua no modelo `RecursosContratados`
 * - Atualize aqui os métodos auxiliares correspondentes
 */
@JvmInline
value class RecursosDisponiveis(val value: RecursosContratados) {

    fun temVideochamadaDisponivel(): Boolean =
        value.videochamadas?.estaEsgotado() == false

    fun possuiIA(): Boolean =
        value.inteligenciaArtificial

    fun possuiTokensIaDisponiveis(): Boolean =
        value.tokensIa.restante() > 0

    fun possuiArmazenamentoDisponivel(): Boolean =
        value.armazenamento.restante() > 0

    fun possuiLicencasDisponiveis(): Boolean =
        value.licencasUsuario.restante() > 0

    fun possuiSmsDisponivel(): Boolean =
        value.envioSms.restante() > 0

    fun possuiEmailsDisponiveis(): Boolean =
        value.envioEmails.restante() > 0

    fun descricaoResumo(): String = buildString {
        appendLine("📦 Armazenamento: ${value.armazenamento.descricao()}")
        appendLine("📨 SMS: ${value.envioSms.descricao()}")
        appendLine("📧 E-mails: ${value.envioEmails.descricao()}")
        appendLine("👥 Licenças: ${value.licencasUsuario.descricao()}")
        appendLine("🤖 Tokens IA: ${value.tokensIa.descricao()}")
        appendLine("📹 Videochamada: ${value.videochamadas?.descricao() ?: "Não disponível"}")
        appendLine("🧠 IA habilitada: ${if (value.inteligenciaArtificial) "Sim" else "Não"}")
    }
}
