package com.pluranex.api_consulta_saas.domain.enums.profissional

enum class EspecialidadeProfissional(val sigla: String, val descricao: String) {
    PSICOLOGIA("PSI", "Psicologia"),
    FONOAUDIOLOGIA("FON", "Fonoaudiologia"),
    FISIOTERAPIA("FIS", "Fisioterapia"),
    TERAPIA_OCUPACIONAL("TOC", "Terapia Ocupacional"),
    MEDICINA("MED", "Medicina"),
    PEDIATRIA("PED", "Pediatria"),
    NUTRICAO("NUT", "Nutrição"),
    ENFERMAGEM("ENF", "Enfermagem"),
    NEUROPSICOLOGIA("NEU", "Neuropsicologia"),
    PSICOPEDAGOGIA("PSP", "Psicopedagogia"),
    OUTRA("OUT", "Outra especialidade")
}
