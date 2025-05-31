package com.pluranex.api_consulta_saas.common.types.tempo

import java.time.DayOfWeek

/**
 * Representa os dias da semana com nomes completos e compatibilidade com [java.time.DayOfWeek].
 */
enum class DiaSemana(val label: String) {
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    override fun toString(): String = label

    companion object {
        fun fromJava(day: DayOfWeek): DiaSemana = when (day) {
            DayOfWeek.MONDAY -> SEGUNDA
            DayOfWeek.TUESDAY -> TERCA
            DayOfWeek.WEDNESDAY -> QUARTA
            DayOfWeek.THURSDAY -> QUINTA
            DayOfWeek.FRIDAY -> SEXTA
            DayOfWeek.SATURDAY -> SABADO
            DayOfWeek.SUNDAY -> DOMINGO
        }
    }
}