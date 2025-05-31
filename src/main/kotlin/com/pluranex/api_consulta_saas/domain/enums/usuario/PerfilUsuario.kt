import com.pluranex.api_consulta_saas.domain.enums.usuario.OrigemPerfil

enum class PerfilUsuario {

    // Superusuários
    MASTER,
    ADMIN,

    // Profissionais da saúde
    MEDICO,
    PSICOLOGO,
    FONOAUDIOLOGO,
    FISIOTERAPEUTA,
    TERAPEUTA_OCUPACIONAL,
    NUTRICIONISTA,
    ENFERMEIRO,

    // Cargos operacionais
    ATENDENTE,
    FINANCEIRO,
    DIRETOR,
    COORDENADOR,

    // Cliente final
    PACIENTE;

    val isAdmin: Boolean
        get() = this in setOf(MASTER, ADMIN, DIRETOR)

    val isMaster: Boolean
        get() = this == MASTER

    val isClinico: Boolean
        get() = this in setOf(
            MEDICO, PSICOLOGO, FONOAUDIOLOGO, FISIOTERAPEUTA,
            TERAPEUTA_OCUPACIONAL, NUTRICIONISTA, ENFERMEIRO
        )

    val isNaoClinico: Boolean
        get() = !isClinico

    val origem: OrigemPerfil
        get() = when (this) {
            MASTER -> OrigemPerfil.SISTEMA
            ADMIN, DIRETOR, COORDENADOR -> OrigemPerfil.ADMINISTRACAO_FINANCEIRA
            FINANCEIRO -> OrigemPerfil.FINANCEIRO
            ATENDENTE -> OrigemPerfil.ATENDENTE_CLINICA
            PACIENTE -> OrigemPerfil.CLIENTE_PACIENTE
            else -> OrigemPerfil.PROFISSIONAL_SAUDE
        }
}
