package com.pluranex.api_consulta_saas.domain.enums.usuario

/**
 * Especialidades clínicas associadas ao usuário logado, usadas no contexto da sessão.
 *
 * Essa enum representa as áreas em que um profissional de saúde atua,
 * como PEDIATRIA ou FONOAUDIOLOGIA. Ela é utilizada para:
 * - Controlar a visibilidade de módulos clínicos
 * - Filtrar dados e fichas conforme a especialidade
 * - Definir permissões clínicas do usuário
 *
 * Para perfis não clínicos (como atendentes ou pacientes), a lista associada a essa enum
 * deve estar vazia.
 */
enum class EspecialidadeAtuacaoUsuario {
    PEDIATRIA,
    PSIQUIATRIA,
    FONOAUDIOLOGIA,
    FISIOTERAPIA,
    NUTRICAO,
    NEUROLOGIA,
    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    ENDOCRINOLOGIA,
    MISTA,
    OUTRAS
}