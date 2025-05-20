package com.pluranex.api_consulta_saas.application.empresa

import com.pluranex.api_consulta_saas.domain.empresa.*
import com.pluranex.api_consulta_saas.domain.empresa.usecase.BuscarEmpresaSaudeUseCase
import com.pluranex.api_consulta_saas.domain.empresa.usecase.CriarEmpresaSaudeUseCase
import com.pluranex.api_consulta_saas.domain.empresa.usecase.ListarEmpresasSaudeUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EmpresaSaudeServiceImpl(
    private val criarEmpresaSaudeUseCase: CriarEmpresaSaudeUseCase,
    private val buscarEmpresaSaudeUseCase: BuscarEmpresaSaudeUseCase,
    private val listarEmpresasSaudeUseCase: ListarEmpresasSaudeUseCase
) : EmpresaSaudeService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(EmpresaSaudeServiceImpl::class.java)
    }

    override fun criarNovaEmpresaSaude(nome: String): EmpresaSaude {
        logger.info("Iniciando criação da empresa de saúde com nome: $nome")
        val empresa = criarEmpresaSaudeUseCase.executar(nome)
        logger.info("Empresa criada com ID: ${empresa.id}")
        return empresa
    }

    override fun buscarEmpresaSaudePorId(id: Long): EmpresaSaude {
        logger.info("Buscando empresa de saúde com ID: $id")
        return buscarEmpresaSaudeUseCase.executar(id)
    }

    override fun listarTodasEmpresasSaude(): List<EmpresaSaude> {
        logger.info("Listando todas as empresas de saúde")
        return listarEmpresasSaudeUseCase.executar()
    }
}
