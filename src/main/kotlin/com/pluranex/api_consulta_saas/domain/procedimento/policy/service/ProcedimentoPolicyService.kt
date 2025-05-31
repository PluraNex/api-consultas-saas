package com.pluranex.api_consulta_saas.domain.procedimento.policy.service

import com.pluranex.api_consulta_saas.domain.enums.clinica.PerfilClinica
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.politica.shared.PolicyService


/**
 * Serviço de política responsável por expor dinamicamente as regras
 * aplicáveis aos procedimentos, com base no perfil da clínica atual.
 *
 * Permite acesso reutilizável às políticas de tipos permitidos, validação e campos obrigatórios.
 */
interface ProcedimentoPolicyService : PolicyService {
    fun verificarPermissaoTipoOuFalhar(tipo: TipoProcedimento, perfil: PerfilClinica)
    fun tiposPermitidos(perfil: PerfilClinica): Set<TipoProcedimento>
}
