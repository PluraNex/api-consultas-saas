package com.pluranex.api_consulta_saas.domain.empresa

interface EmpresaSaudeRepository {
    fun salvar(empresa: EmpresaSaude): EmpresaSaude
    fun buscarPorId(id: Long): EmpresaSaude?
    fun listarTodas(): List<EmpresaSaude>
}
