package com.pluranex.api_consulta_saas.domain.crm

import com.pluranex.api_consulta_saas.domain.crm.filter.FiltroCrm

interface CrmService {
    fun criarPerfilRelacionamento(perfil: PerfilRelacionamentoCrm): PerfilRelacionamentoCrm
    fun registrarInteracao(interacao: InteracaoCrm): InteracaoCrm
    fun registrarPreferencia(preferencia: PreferenciaCanalCrm): PreferenciaCanalCrm
    fun atualizarPreferencia(preferencia: PreferenciaCanalCrm): PreferenciaCanalCrm
    fun listarPerfisRelacionamento(filtro: FiltroCrm): List<PerfilRelacionamentoCrm>
    fun detalharPerfilRelacionamento(id: Long): PerfilRelacionamentoCrm
}
