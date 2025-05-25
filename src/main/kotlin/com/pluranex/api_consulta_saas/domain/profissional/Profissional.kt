package com.pluranex.api_consulta_saas.domain.profissional

import com.pluranex.api_consulta_saas.domain.enums.profissional.TipoVinculoProfissional

import com.pluranex.api_consulta_saas.common.session.enums.EspecialidadeUsuario
import com.pluranex.api_consulta_saas.domain.enums.profissional.StatusAtendimento
import java.time.LocalDateTime

data class Profissional(
    val id: Long? = null,

    // Vínculo com o usuário autenticável
    val usuarioId: Long,
    val tipoVinculo: TipoVinculoProfissional = TipoVinculoProfissional.COLABORADOR,

    // Informações clínicas
    val registroProfissional: String,               // CRM, CRP, CREFITO, etc.
    val conselhoProfissional: String? = null,
    val especialidades: List<EspecialidadeUsuario>, // Pode ser múltipla
    val cpf: String? = null,                         // Para prontuários e relatórios

    // Identidade visual
    val nomeApresentacao: String? = null,

    // Parâmetros de consulta
    val duracaoPadraoConsultaMin: Int = 30,
    val diasDisponiveis: List<String>? = null,
    val permiteGerenciarAgenda: Boolean = false,

    // Status dinâmico para dashboards ou telemedicina
    val statusAtendimento: StatusAtendimento = StatusAtendimento.DISPONIVEL,
    val linkAtendimentoOnline: String? = null,

    // Controle
    val ativo: Boolean = true,
    val criadoPor: String? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now()
)
