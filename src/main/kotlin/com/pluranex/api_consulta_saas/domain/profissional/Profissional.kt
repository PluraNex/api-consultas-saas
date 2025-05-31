package com.pluranex.api_consulta_saas.domain.profissional

import com.pluranex.api_consulta_saas.common.types.agenda.DisponibilidadeProfissional
import com.pluranex.api_consulta_saas.common.types.profissional.ProfissionalId
import com.pluranex.api_consulta_saas.common.types.profissional.RegistroProfissional
import com.pluranex.api_consulta_saas.common.types.tempo.DuracaoConsulta
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.common.types.usuario.UserId
import com.pluranex.api_consulta_saas.domain.enums.profissional.*
import java.time.LocalDateTime

/**
 * Entidade de domínio que representa um profissional de saúde atuando em uma clínica.
 *
 * É associada a um [Usuario] autenticável e reflete sua atuação clínica dentro de um [Tenant] (clínica).
 *
 * ### Responsabilidades:
 * - Representar dados regulatórios e institucionais (registro, conselho, vínculo)
 * - Representar especialidades clínicas
 * - Informar disponibilidade padrão para agendamento
 * - Permitir controle de status e permissões relacionadas à agenda
 */
data class Profissional(
    val id: ProfissionalId? = null,

    /** Identificador do tenant (clínica) ao qual o profissional está vinculado. */
    val tenantId: TenantId,

    /** Identificador do usuário autenticável que representa este profissional. */
    val usuarioId: UserId,

    /** Tipo de vínculo contratual com a clínica. */
    val tipoVinculo: TipoVinculoProfissional = TipoVinculoProfissional.COLABORADOR,

    /** Número de registro no conselho profissional (ex: CRM, CRP, etc.). */
    val registroProfissional: RegistroProfissional,

    /** Conselho profissional ao qual está vinculado. */
    val conselhoProfissional: ConselhoProfissional? = null,

    /** Especialidades clínicas declaradas para atuação. */
    val especialidades: List<EspecialidadeProfissional>,

    /** Nome de exibição usado em agendas, prontuários e relatórios. */
    val nomeApresentacao: String? = null,

    /** Duração padrão (em minutos) para consultas agendadas com este profissional. */
    val duracaoPadraoConsulta: DuracaoConsulta = DuracaoConsulta.MINUTOS_40,

    /** Disponibilidade semanal padrão do profissional. */
    val disponibilidade: DisponibilidadeProfissional? = null,

    /** Indica se o profissional tem permissão para gerenciar sua própria agenda. */
    val permiteGerenciarAgenda: Boolean = false,

    /** Status atual de atendimento (disponível, ausente, etc.). */
    val statusAtendimento: StatusAtendimento = StatusAtendimento.DISPONIVEL,

    /** Link para atendimentos online, se aplicável. */
    val linkAtendimentoOnline: String? = null,

    /** Indica se o profissional está ativo na clínica. */
    val ativo: Boolean = true,

    /** Usuário responsável pela criação do cadastro. */
    val criadoPor: String? = null,

    /** Data e hora de criação do registro. */
    val criadoEm: LocalDateTime = LocalDateTime.now()
)
