package com.pluranex.api_consulta_saas.domain.procedimento.policy.implementation

import com.pluranex.api_consulta_saas.common.annotations.Policy
import com.pluranex.api_consulta_saas.domain.enums.politica.NomePolitica
import com.pluranex.api_consulta_saas.domain.enums.politica.TipoPolitica
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento
import com.pluranex.api_consulta_saas.domain.procedimento.entity.Procedimento
import com.pluranex.api_consulta_saas.domain.procedimento.policy.definition.ProcedimentoPolicy
import org.springframework.stereotype.Component

/**
 * Política de procedimentos específica para clínicas com perfil de Desenvolvimento Infantil.
 *
 * Define os tipos de procedimentos permitidos e os campos obrigatórios
 * com base nas regras e particularidades deste perfil de clínica.
 *
 * Essa política é automaticamente resolvida pela [ProcedimentoPolicyFactory]
 * através da anotação [@Policy], com nome e tipo específicos.
 */
@Policy(name = NomePolitica.INFANTIL, type = TipoPolitica.PROCEDIMENTO)
@Component
class ProcedimentoPolicyDesenvolvimentoInfantil : ProcedimentoPolicy {

    private val tiposPermitidos = setOf(
        TipoProcedimento.CONSULTA_INICIAL,
        TipoProcedimento.CONSULTA_RETORNO,
        TipoProcedimento.AVALIACAO_CLINICA,
        TipoProcedimento.AVALIACAO_PSICOLOGICA,
        TipoProcedimento.AVALIACAO_FONOAUDIOLOGICA,
        TipoProcedimento.AVALIACAO_NUTRICIONAL,
        TipoProcedimento.AVALIACAO_FISIOTERAPICA,
        TipoProcedimento.AVALIACAO_PSICOPEDAGOGICA,
        TipoProcedimento.TERAPIA_COMPORTAMENTAL,
        TipoProcedimento.TERAPIA_OCUPACIONAL,
        TipoProcedimento.TERAPIA_FONOAUDIOLOGICA,
        TipoProcedimento.PSICOTERAPIA,
        TipoProcedimento.INTERVENCAO_ABA,
        TipoProcedimento.PSICOPEDAGOGIA,
        TipoProcedimento.ESTIMULACAO_PRECOCE,
        TipoProcedimento.INTEGRACAO_SENSORIAL,
        TipoProcedimento.OFICINA_PSICOMOTRICIDADE,
        TipoProcedimento.OFICINA_ALIMENTACAO,
        TipoProcedimento.GRUPO_SOCIALIZACAO,
        TipoProcedimento.GRUPO_PAIS,
        TipoProcedimento.ANAMNESE,
        TipoProcedimento.PLANEJAMENTO_TERAPEUTICO,
        TipoProcedimento.RELATORIO_EVOLUTIVO,
        TipoProcedimento.EMISSAO_LAUDO,
        TipoProcedimento.REUNIAO_ESCOLAR,
        TipoProcedimento.REUNIAO_EQUIPE,
        TipoProcedimento.TAXA_AGENDAMENTO
    )


    override fun tiposPermitidos(): Set<TipoProcedimento> = tiposPermitidos
}
