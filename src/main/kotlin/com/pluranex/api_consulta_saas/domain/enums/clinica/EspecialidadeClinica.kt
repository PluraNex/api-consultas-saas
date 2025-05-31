package com.pluranex.api_consulta_saas.domain.enums.clinica

enum class EspecialidadeClinica(val sigla: String, val descricao: String) {

    // INFANTIL / DESENVOLVIMENTO
    DESENVOLVIMENTO_INFANTIL("INF", "Desenvolvimento Infantil"),
    TEA("TEA", "Transtorno do Espectro Autista"),
    PSICOPEDAGOGIA("PSP", "Psicopedagogia"),

    // MULTIDISCIPLINAR / REABILITAÇÃO
    FONOAUDIOLOGIA("FON", "Fonoaudiologia"),
    FISIOTERAPIA("FIS", "Fisioterapia"),
    TERAPIA_OCUPACIONAL("TOC", "Terapia Ocupacional"),
    NUTRICAO("NUT", "Nutrição"),
    EDUCACAO_FISICA("EDF", "Educação Física"),
    TERAPIA_INTEGRATIVA("TIN", "Terapia Integrativa"),

    // SAÚDE MENTAL
    PSICOLOGIA("PSI", "Psicologia"),
    NEUROPSICOLOGIA("NEU", "Neuropsicologia"),
    PSIQUIATRIA("PSIQ", "Psiquiatria"),

    // ESPECIALIDADES MÉDICAS
    PEDIATRIA("PED", "Pediatria"),
    GINECOLOGIA("GIN", "Ginecologia"),
    OBSTETRICIA("OBS", "Obstetrícia"),
    ENDOCRINOLOGIA("END", "Endocrinologia"),
    NEUROLOGIA("NRL", "Neurologia"),
    CARDIOLOGIA("CAR", "Cardiologia"),
    DERMATOLOGIA("DERM", "Dermatologia"),
    ORTOPEDIA("ORT", "Ortopedia"),
    REUMATOLOGIA("REU", "Reumatologia"),

    // CLÍNICA GERAL / FAMILIAR
    CLINICA_GERAL("CLG", "Clínica Geral"),
    MEDICINA_FAMILIAR("MFAM", "Medicina da Família"),
    GERIATRIA("GER", "Geriatria"),

    // OUTROS
    OUTRA("OUT", "Outra especialidade clínica");

    override fun toString(): String = descricao

    companion object {
        fun porSigla(sigla: String): EspecialidadeClinica? =
            EspecialidadeClinica.entries.find { it.sigla.equals(sigla.trim(), ignoreCase = true) }

        fun siglas(): List<String> = EspecialidadeClinica.entries.map { it.sigla }

        fun descricoes(): List<String> = EspecialidadeClinica.entries.map { it.descricao }

        fun mapSiglaParaDescricao(): Map<String, String> =
            EspecialidadeClinica.entries.associate { it.sigla to it.descricao }
    }
}
