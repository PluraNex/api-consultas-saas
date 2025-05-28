package com.pluranex.api_consulta_saas.domain.enums.procedimento.extension

import com.pluranex.api_consulta_saas.domain.enums.procedimento.CategoriaProcedimento
import com.pluranex.api_consulta_saas.domain.enums.procedimento.TipoProcedimento

/**
 * Extensão utilitária para mapear um [TipoProcedimento] à sua [CategoriaProcedimento] correspondente.
 * Pode ser utilizada em filtros de UI, regras de negócio e relatórios.
 */
fun TipoProcedimento.toCategoria(): CategoriaProcedimento = when (this) {
    // 🩺 Consultas e Avaliações
    TipoProcedimento.CONSULTA_INICIAL,
    TipoProcedimento.CONSULTA_RETORNO,
    TipoProcedimento.AVALIACAO_CLINICA,
    TipoProcedimento.AVALIACAO_PSICOLOGICA,
    TipoProcedimento.AVALIACAO_FONOAUDIOLOGICA,
    TipoProcedimento.AVALIACAO_NUTRICIONAL,
    TipoProcedimento.AVALIACAO_PSICOPEDAGOGICA,
    TipoProcedimento.AVALIACAO_NEUROPSICOLOGICA,
    TipoProcedimento.AVALIACAO_FISIOTERAPICA -> CategoriaProcedimento.CONSULTA

    // 🧠 Terapias Individuais ou em grupo
    TipoProcedimento.TERAPIA_OCUPACIONAL,
    TipoProcedimento.TERAPIA_FONOAUDIOLOGICA,
    TipoProcedimento.TERAPIA_COMPORTAMENTAL,
    TipoProcedimento.TERAPIA_FAMILIAR,
    TipoProcedimento.PSICOTERAPIA,
    TipoProcedimento.FISIOTERAPIA,
    TipoProcedimento.TERAPIA_INTEGRATIVA,
    TipoProcedimento.TERAPIA_NEUROPSICOLOGICA,
    TipoProcedimento.INTERVENCAO_ABA,
    TipoProcedimento.PSICOPEDAGOGIA,
    TipoProcedimento.ESTIMULACAO_PRECOCE,
    TipoProcedimento.INTEGRACAO_SENSORIAL,
    TipoProcedimento.GRUPO_SOCIALIZACAO,
    TipoProcedimento.GRUPO_PAIS,
    TipoProcedimento.OFICINA_PSICOMOTRICIDADE,
    TipoProcedimento.OFICINA_ALIMENTACAO,
    TipoProcedimento.OFICINA_COGNITIVA,
    TipoProcedimento.OFICINA_SOCIOEMOCIONAL,
    TipoProcedimento.SESSAO_AVULSA -> CategoriaProcedimento.TERAPIA

    // 🔬 Exames e Testes Diagnósticos
    TipoProcedimento.EXAME_LABORATORIAL,
    TipoProcedimento.EXAME_NEUROPSICOLOGICO,
    TipoProcedimento.TESTE_AUDITIVO,
    TipoProcedimento.TESTE_VISUAL,
    TipoProcedimento.TESTE_ALERGICO,
    TipoProcedimento.TESTE_APRENDIZAGEM -> CategoriaProcedimento.EXAME

    // 📋 Documentação Clínica
    TipoProcedimento.ADMISSAO_CLINICA,
    TipoProcedimento.ENCAMINHAMENTO,
    TipoProcedimento.ORIENTACAO_ESCOLAR,
    TipoProcedimento.ORIENTACAO_FAMILIAR,
    TipoProcedimento.ANAMNESE,
    TipoProcedimento.PLANEJAMENTO_TERAPEUTICO,
    TipoProcedimento.SUPERVISAO_CLINICA,
    TipoProcedimento.RELATORIO_EVOLUTIVO,
    TipoProcedimento.RELATORIO_PERICIAL,
    TipoProcedimento.EMISSAO_LAUDO,
    TipoProcedimento.RELATORIO_PEDAGOGICO,
    TipoProcedimento.PLANO_INTERVENCAO_ESCOLAR -> CategoriaProcedimento.RELATORIO

    // 🗂️ Apoio Escolar / Educacional
    TipoProcedimento.ACOMPANHAMENTO_ESCOLAR,
    TipoProcedimento.SUPORTE_ESCOLAR,
    TipoProcedimento.REUNIAO_EQUIPE,
    TipoProcedimento.REUNIAO_ESCOLAR -> CategoriaProcedimento.ADMINISTRATIVO

    // 💵 Financeiros / Serviços Diversos
    TipoProcedimento.TAXA_AGENDAMENTO,
    TipoProcedimento.TAXA_RELATORIO -> CategoriaProcedimento.FINANCEIRO

    // ❓ Outros
    TipoProcedimento.OUTRO -> CategoriaProcedimento.OUTRO
}
