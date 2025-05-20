package com.pluranex.api_consulta_saas.domain.empresa

interface EmpresaSaudeService {
    fun criarNovaEmpresaSaude(nome: String): EmpresaSaude
    fun buscarEmpresaSaudePorId(id: Long): EmpresaSaude
    fun listarTodasEmpresasSaude(): List<EmpresaSaude>
}
