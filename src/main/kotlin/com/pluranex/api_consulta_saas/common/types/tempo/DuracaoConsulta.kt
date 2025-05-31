package com.pluranex.api_consulta_saas.common.types.tempo

@JvmInline
value class DuracaoConsulta(val minutos: Int) {
    init {
        require(minutos > 0) { "A duração da consulta deve ser positiva." }
    }

    override fun toString(): String = "$minutos minutos"

    companion object {
        val MINUTOS_40 = DuracaoConsulta(40)
    }
}
