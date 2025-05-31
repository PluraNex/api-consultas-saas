package com.pluranex.api_consulta_saas.common.types.tempo

import java.io.Serializable

/**
 * Value object que representa um intervalo de tempo no formato `HH:mm` → `HH:mm`.
 *
 * - Valida o formato de entrada e ordem dos horários.
 * - Pode ser utilizado em agendas, bloqueios, turnos e disponibilidade.
 *
 * Exemplo:
 * ```
 * val intervalo = IntervaloHorario("08:00", "12:00")
 * ```
 */
data class IntervaloHorario(
    val inicio: String,
    val fim: String
) : Serializable {

    init {
        require(inicio.matches(HH_MM)) { "Horário de início inválido: $inicio" }
        require(fim.matches(HH_MM)) { "Horário de fim inválido: $fim" }
        require(inicio < fim) { "O horário de início deve ser anterior ao horário de fim." }
    }

    companion object {
        private val HH_MM = Regex("""^\d{2}:\d{2}$""")
    }
}