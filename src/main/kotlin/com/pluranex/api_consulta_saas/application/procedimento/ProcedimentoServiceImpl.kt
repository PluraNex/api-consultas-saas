package com.pluranex.api_consulta_saas.application.procedimento

import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.procedimento.policy.service.ProcedimentoPolicyService
import com.pluranex.api_consulta_saas.domain.procedimento.ProcedimentoService
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.usecase.CriarProcedimentoUseCase
import com.pluranex.api_consulta_saas.domain.sessao.SessaoService
import org.springframework.stereotype.Service

/**
 * Serviço de aplicação responsável por orquestrar operações relacionadas a procedimentos.
 *
 * Resolve a política vigente da clínica e delega a execução dos casos de uso.
 */
@Service
class ProcedimentoServiceImpl(
    private val procedimentoPolicyService: ProcedimentoPolicyService,
    private val criarProcedimentoUseCase: CriarProcedimentoUseCase,
    private val sessaoService: SessaoService
) : ProcedimentoService {

    override fun criarProcedimento(procedimento: Procedimento): Procedimento {
        val sessao = sessaoService.obterContextoSessao()
        val perfil = sessao.contexto.perfilClinica
        val tenantId = sessao.usuario.tenantId

        procedimentoPolicyService.verificarPermissaoTipoOuFalhar(procedimento.tipo, perfil)

        val procedimentoComTenant = procedimento.copy(tenantId = tenantId)
        return criarProcedimentoUseCase.executar(procedimentoComTenant)
    }

    override fun listarTiposProcedimento(): List<TipoProcedimento> {
        val perfil = sessaoService.obterContextoSessao().contexto.perfilClinica
        return procedimentoPolicyService.tiposPermitidos(perfil).toList()
    }
}

