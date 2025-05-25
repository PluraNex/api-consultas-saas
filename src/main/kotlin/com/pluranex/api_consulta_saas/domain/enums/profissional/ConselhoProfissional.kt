package com.pluranex.api_consulta_saas.domain.enums.profissional

/**
 * Enum que representa os principais conselhos profissionais da área da saúde.
 * Utilizado para validação e exibição padronizada dos registros de profissionais.
 */
enum class ConselhoProfissional(val descricao: String) {
    CRM("Conselho Regional de Medicina"),
    CRP("Conselho Regional de Psicologia"),
    CREFITO("Conselho Regional de Fisioterapia e Terapia Ocupacional"),
    CRF("Conselho Regional de Farmácia"),
    CRO("Conselho Regional de Odontologia"),
    COREN("Conselho Regional de Enfermagem"),
    CFFA("Conselho Federal de Fonoaudiologia"),
    CRN("Conselho Regional de Nutrição"),
    CRMV("Conselho Regional de Medicina Veterinária"),
    CREF("Conselho Regional de Educação Física"),
    CRBM("Conselho Regional de Biomedicina"),
    CRBIO("Conselho Regional de Biologia"),
    OUTRO("Outro conselho profissional");

    override fun toString(): String = descricao
}
