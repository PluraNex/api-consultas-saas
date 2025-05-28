package com.pluranex.api_consulta_saas.domain.enums.clinica

/**
 * Representa o perfil funcional e o foco principal da clínica,
 * utilizado para aplicar regras específicas de negócio, validar
 * procedimentos permitidos e personalizar fluxos clínicos.
 *
 * Diferente de [EspecialidadeClinica], que lista áreas técnicas
 * de atuação, o [PerfilClinica] define o tipo institucional da clínica.
 *
 * Exemplos de uso:
 * - Aplicação de políticas clínicas customizadas
 * - Seleção de fichas de anamnese específicas
 * - Restrição ou permissão de procedimentos clínicos
 */
enum class

PerfilClinica(val descricao: String) {

    /**
     * Clínica voltada ao atendimento interdisciplinar de crianças,
     * geralmente com foco em desenvolvimento neurológico, emocional,
     * motor, comportamental e de linguagem.
     *
     * Especialidades comuns: psicologia infantil, fonoaudiologia,
     * psicopedagogia, terapia ABA, nutrição infantil, fisioterapia pediátrica.
     */
    DESENVOLVIMENTO_INFANTIL("Clínica de Desenvolvimento Infantil"),

    /**
     * Clínica de saúde geral, com múltiplas especialidades médicas e não médicas,
     * com escopo ambulatorial comum a clínicas de bairro, atendimento familiar ou ocupacional.
     */
    CLINICA_GERAL("Clínica Geral"),

    /**
     * Clínica especializada em cardiologia e saúde cardiovascular.
     */
    CARDIOLOGIA("Clínica de Cardiologia"),

    /**
     * Clínica voltada à terceira idade, com foco em saúde geriátrica e suporte a pacientes idosos.
     */
    GERIATRIA("Clínica Geriátrica"),

    /**
     * Clínica que possui múltiplos focos e não se enquadra em uma categoria específica.
     */
    MULTIDISCIPLINAR("Clínica Multidisciplinar"),

    /**
     * Perfil genérico utilizado como fallback quando o perfil da clínica não está definido.
     */
    INDEFINIDO("Perfil Indefinido");

    override fun toString(): String = descricao
}
