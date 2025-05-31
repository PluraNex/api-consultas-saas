package com.pluranex.api_consulta_saas.domain.procedimento.repository

import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import java.util.UUID

/**
 * Contrato para persistência e consulta de procedimentos no domínio.
 *
 * As implementações dessa interface devem ser responsáveis por garantir
 * a integridade e filtragem dos dados conforme o tenant e perfil da clínica.
 */
interface ProcedimentoRepository {

    /**
     * Salva um novo procedimento ou atualiza um existente.
     *
     * @param procedimento Procedimento a ser salvo.
     * @return Procedimento persistido com ID atualizado (caso seja criação).
     */
    fun salvar(procedimento: Procedimento): Procedimento

    /**
     * Busca um procedimento pelo ID.
     *
     * Garante que o procedimento pertença ao tenant atual.
     *
     * @param id Identificador único do procedimento.
     * @return Procedimento encontrado ou exceção caso não exista.
     */
    fun buscarPorId(id: UUID): Procedimento?

    /**
     * Lista todos os procedimentos permitidos para a clínica atual da sessão.
     *
     * @return Lista de procedimentos válidos.
     */
    fun listarTodos(): List<Procedimento>
}