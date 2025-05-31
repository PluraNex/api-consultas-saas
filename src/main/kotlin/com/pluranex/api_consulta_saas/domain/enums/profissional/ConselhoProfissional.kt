package com.pluranex.api_consulta_saas.domain.enums.profissional

import com.pluranex.api_consulta_saas.domain.enums.usuario.EspecialidadeAtuacaoUsuario

/**
 * Enum que representa os principais conselhos profissionais da área da saúde.
 * Inclui sigla, descrição e especialidades compatíveis.
 */
enum class ConselhoProfissional(
    val sigla: String,
    val descricao: String,
    val especialidadesCompatíveis: Set<EspecialidadeAtuacaoUsuario> = emptySet()
) {

    CRM(
        sigla = "CRM",
        descricao = "Conselho Regional de Medicina",
        especialidadesCompatíveis = setOf(
            EspecialidadeAtuacaoUsuario.MEDICINA,
            EspecialidadeAtuacaoUsuario.PEDIATRIA
        )
    ),

    CRP(
        sigla = "CRP",
        descricao = "Conselho Regional de Psicologia",
        especialidadesCompatíveis = setOf(
            EspecialidadeAtuacaoUsuario.PSICOLOGIA,
            EspecialidadeAtuacaoUsuario.NEUROPSICOLOGIA
        )
    ),

    CREFITO(
        sigla = "CREFITO",
        descricao = "Conselho Regional de Fisioterapia e Terapia Ocupacional",
        especialidadesCompatíveis = setOf(
            EspecialidadeAtuacaoUsuario.FISIOTERAPIA,
            EspecialidadeAtuacaoUsuario.TERAPIA_OCUPACIONAL
        )
    ),

    CRF(
        sigla = "CRF",
        descricao = "Conselho Regional de Farmácia"
    ),

    CRO(
        sigla = "CRO",
        descricao = "Conselho Regional de Odontologia"
    ),

    COREN(
        sigla = "COREN",
        descricao = "Conselho Regional de Enfermagem"
    ),

    CFFA(
        sigla = "CFFA",
        descricao = "Conselho Federal de Fonoaudiologia",
        especialidadesCompatíveis = setOf(
            EspecialidadeAtuacaoUsuario.FONOAUDIOLOGIA
        )
    ),

    CRN(
        sigla = "CRN",
        descricao = "Conselho Regional de Nutrição",
        especialidadesCompatíveis = setOf(
            EspecialidadeAtuacaoUsuario.NUTRICAO
        )
    ),

    CRMV(
        sigla = "CRMV",
        descricao = "Conselho Regional de Medicina Veterinária"
    ),

    CREF(
        sigla = "CREF",
        descricao = "Conselho Regional de Educação Física"
    ),

    CRBM(
        sigla = "CRBM",
        descricao = "Conselho Regional de Biomedicina"
    ),

    CRBIO(
        sigla = "CRBIO",
        descricao = "Conselho Regional de Biologia"
    ),

    OUTRO(
        sigla = "OUTRO",
        descricao = "Outro conselho profissional"
    );

    override fun toString(): String = descricao

    fun aceitaEspecialidade(especialidade: EspecialidadeAtuacaoUsuario): Boolean {
        return especialidadesCompatíveis.isEmpty() || especialidadesCompatíveis.contains(especialidade)
    }

    companion object {

        fun porSigla(sigla: String): ConselhoProfissional? =
            values().find { it.sigla.equals(sigla.trim(), ignoreCase = true) }

        fun listaPorEspecialidade(especialidade: EspecialidadeAtuacaoUsuario): List<ConselhoProfissional> =
            values().filter { it.aceitaEspecialidade(especialidade) }

        fun siglas(): List<String> = values().map { it.sigla }

        fun descricoes(): List<String> = values().map { it.descricao }

        fun mapSiglaParaDescricao(): Map<String, String> =
            values().associate { it.sigla to it.descricao }
    }
}
