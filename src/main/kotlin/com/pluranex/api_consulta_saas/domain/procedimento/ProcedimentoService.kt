package com.pluranex.api_consulta_saas.domain.procedimento

import java.util.*

interface ProcedimentoService {

    /**
     * Retorna os procedimentos habilitados para a clínica atual da sessão.
     */
    fun listarProcedimentosPermitidos(): List<Procedimento>

    /**
     * Busca um procedimento específico por ID, garantindo que ele esteja habilitado para a clínica atual.
     */
    fun buscarPorId(id: UUID): Procedimento
}
