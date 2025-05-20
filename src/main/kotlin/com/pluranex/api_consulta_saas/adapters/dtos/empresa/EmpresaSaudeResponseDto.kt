package com.pluranex.api_consulta_saas.adapters.dtos.empresa

import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaude

data class EmpresaSaudeResponseDto(
    val id: Long?,
    val nome: String
) {
    companion object {
        fun fromDomain(empresa: EmpresaSaude) = EmpresaSaudeResponseDto(
            id = empresa.id,
            nome = empresa.nome
        )
    }
}
