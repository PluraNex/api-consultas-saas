import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import java.time.Duration
import java.time.LocalDateTime

data class ConfiguracaoNotificacaoResponseDto(
    val id: Long?,
    val canaisAtivos: List<CanalNotificacao>,
    val agendadaPara: LocalDateTime?,
    val tempoAntecedenciaLembrete: Duration,
    val tempoAntecedenciaConfirmacao: Duration,
    val isDefault: Boolean
) {
    companion object {
        fun fromDomain(configuracao: ConfiguracaoNotificacao): ConfiguracaoNotificacaoResponseDto {
            return ConfiguracaoNotificacaoResponseDto(
                id = configuracao.id, // Agora o ID é incluído
                canaisAtivos = configuracao.canaisAtivos,
                agendadaPara = configuracao.agendadaPara,
                tempoAntecedenciaLembrete = configuracao.tempoAntecedenciaLembrete,
                tempoAntecedenciaConfirmacao = configuracao.tempoAntecedenciaConfirmacao,
                isDefault = configuracao.isDefault
            )
        }
    }
}
