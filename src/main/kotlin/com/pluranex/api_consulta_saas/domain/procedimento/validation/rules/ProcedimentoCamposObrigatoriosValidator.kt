package com.pluranex.api_consulta_saas.domain.procedimento.validation.rules

import com.pluranex.api_consulta_saas.common.annotations.Validator
import com.pluranex.api_consulta_saas.common.session.core.contexto.ContextoSessaoResolver
import com.pluranex.api_consulta_saas.domain.politica.procedimento.ProcedimentoPolicyFactory
import com.pluranex.api_consulta_saas.domain.procedimento.Procedimento

/**
 * Validador responsável por garantir que os campos obrigatórios de um [Procedimento]
 * estejam preenchidos de acordo com a política vigente da clínica.
 *
 * A definição dos campos obrigatórios varia conforme o perfil da clínica,
 * sendo obtida dinamicamente a partir da [ProcedimentoPolicyFactory].
 *
 * Essa validação é complementar à verificação de permissão de tipo de procedimento,
 * e deve ser executada após a verificação de política.
 *
 * Exceções:
 * - Lança [IllegalArgumentException] caso algum campo obrigatório esteja ausente ou inválido.
 *
 * Regras aplicadas:
 * - Verifica campos como: descrição, categoria, responsável, etc.
 *
 * Uso:
 * ```
 * procedimentoCamposObrigatoriosValidator.validar(procedimento)
 * ```
 */
@Validator
class ProcedimentoCamposObrigatoriosValidator(
    private val procedimentoPolicyFactory: ProcedimentoPolicyFactory,
    private val contextoSessaoResolver: ContextoSessaoResolver
) {

    /**
     * Executa a validação dos campos obrigatórios com base na política da clínica atual.
     *
     * @param procedimento O procedimento a ser validado.
     *
     * @throws IllegalArgumentException se houver campos obrigatórios ausentes ou inválidos.
     */
    fun validar(procedimento: Procedimento) {
        val perfil = contextoSessaoResolver.obterPerfil()
        val politica = procedimentoPolicyFactory.resolver(perfil)

        val camposFaltando = politica.camposObrigatorios(procedimento).filter { campo ->
            when (campo) {
                "descricao"   -> procedimento.descricao.isNullOrBlank()
                "categoria"   -> procedimento.categoria == null
                else          -> false
            }
        }

        if (camposFaltando.isNotEmpty()) {
            throw IllegalArgumentException(
                "Campos obrigatórios ausentes ou inválidos: ${camposFaltando.joinToString(", ")}"
            )
        }
    }
}
