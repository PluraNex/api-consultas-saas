package com.pluranex.api_consulta_saas.domain.politica.procedimento

import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento

/**
 * Define o contrato para regras de negócio específicas relacionadas ao [Procedimento],
 * permitindo variações de lógica conforme o perfil da clínica ou especialidade.
 */
interface ProcedimentoPolicy {

    /**
     * Verifica se o procedimento informado é permitido dentro da política em vigor.
     */
    fun permite(procedimento: Procedimento): Boolean

    /**
     * Lista os campos obrigatórios para o procedimento nesta política.
     */
    fun camposObrigatorios(procedimento: Procedimento): Set<String>
}
