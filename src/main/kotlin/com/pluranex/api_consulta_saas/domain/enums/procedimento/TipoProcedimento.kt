package com.pluranex.api_consulta_saas.domain.enums.procedimento

/**
 * Representa os tipos principais de procedimentos clínicos que podem ser realizados,
 * como consultas, terapias, exames ou documentos. Este enum é utilizado para:
 *
 * - Classificar procedimentos cadastrados no sistema.
 * - Aplicar regras específicas de negócio e políticas clínicas.
 * - Definir comportamentos em fluxos como prontuário, agendamento e repasse.
 *
 * @property descricao Descrição textual amigável para interfaces e documentos.
 * @property categoria Categoria funcional do procedimento para agrupamento e lógica de negócio.
 */
enum class TipoProcedimento(
    val descricao: String,
    val categoria: CategoriaProcedimento
) {

    // 🩺 CONSULTAS E AVALIAÇÕES
    CONSULTA_INICIAL("Consulta Inicial", CategoriaProcedimento.CONSULTA),
    CONSULTA_RETORNO("Retorno", CategoriaProcedimento.CONSULTA),
    AVALIACAO_CLINICA("Avaliação Clínica", CategoriaProcedimento.CONSULTA),
    AVALIACAO_PSICOLOGICA("Avaliação Psicológica", CategoriaProcedimento.CONSULTA),
    AVALIACAO_FONOAUDIOLOGICA("Avaliação Fonoaudiológica", CategoriaProcedimento.CONSULTA),
    AVALIACAO_NUTRICIONAL("Avaliação Nutricional", CategoriaProcedimento.CONSULTA),
    AVALIACAO_FISIOTERAPICA("Avaliação Fisioterapêutica", CategoriaProcedimento.CONSULTA),
    AVALIACAO_PSICOPEDAGOGICA("Avaliação Psicopedagógica", CategoriaProcedimento.CONSULTA),
    AVALIACAO_NEUROPSICOLOGICA("Avaliação Neuropsicológica", CategoriaProcedimento.CONSULTA),

    // 🧠 TERAPIAS INDIVIDUAIS E GRUPAIS
    TERAPIA_OCUPACIONAL("Terapia Ocupacional", CategoriaProcedimento.TERAPIA),
    TERAPIA_FONOAUDIOLOGICA("Terapia Fonoaudiológica", CategoriaProcedimento.TERAPIA),
    TERAPIA_COMPORTAMENTAL("Terapia Comportamental", CategoriaProcedimento.TERAPIA),
    TERAPIA_FAMILIAR("Terapia Familiar", CategoriaProcedimento.TERAPIA),
    TERAPIA_INTEGRATIVA("Terapia Integrativa", CategoriaProcedimento.TERAPIA),
    TERAPIA_NEUROPSICOLOGICA("Terapia Neuropsicológica", CategoriaProcedimento.TERAPIA),
    PSICOTERAPIA("Psicoterapia", CategoriaProcedimento.TERAPIA),
    FISIOTERAPIA("Fisioterapia", CategoriaProcedimento.TERAPIA),
    INTERVENCAO_ABA("Intervenção ABA", CategoriaProcedimento.TERAPIA),
    PSICOPEDAGOGIA("Psicopedagogia", CategoriaProcedimento.TERAPIA),
    ESTIMULACAO_PRECOCE("Estimulação Precoce", CategoriaProcedimento.TERAPIA),
    INTEGRACAO_SENSORIAL("Integração Sensorial", CategoriaProcedimento.TERAPIA),
    ACOMPANHAMENTO_ESCOLAR("Acompanhamento Escolar", CategoriaProcedimento.TERAPIA),
    GRUPO_SOCIALIZACAO("Grupo de Socialização", CategoriaProcedimento.TERAPIA),
    GRUPO_PAIS("Grupo de Pais", CategoriaProcedimento.TERAPIA),
    OFICINA_PSICOMOTRICIDADE("Oficina de Psicomotricidade", CategoriaProcedimento.TERAPIA),
    OFICINA_ALIMENTACAO("Oficina de Alimentação", CategoriaProcedimento.TERAPIA),
    OFICINA_COGNITIVA("Oficina Cognitiva", CategoriaProcedimento.TERAPIA),
    OFICINA_SOCIOEMOCIONAL("Oficina Socioemocional", CategoriaProcedimento.TERAPIA),
    SESSAO_AVULSA("Sessão Avulsa", CategoriaProcedimento.TERAPIA),

    // 🔬 EXAMES E TESTES
    EXAME_LABORATORIAL("Exame Laboratorial", CategoriaProcedimento.EXAME),
    EXAME_NEUROPSICOLOGICO("Exame Neuropsicológico", CategoriaProcedimento.EXAME),
    TESTE_AUDITIVO("Teste Auditivo", CategoriaProcedimento.EXAME),
    TESTE_VISUAL("Teste Visual", CategoriaProcedimento.EXAME),
    TESTE_ALERGICO("Teste Alérgico", CategoriaProcedimento.EXAME),
    TESTE_APRENDIZAGEM("Teste de Aprendizagem", CategoriaProcedimento.EXAME),

    // 📋 DOCUMENTOS E RELATÓRIOS
    ADMISSAO_CLINICA("Admissão Clínica", CategoriaProcedimento.RELATORIO),
    ENCAMINHAMENTO("Encaminhamento", CategoriaProcedimento.RELATORIO),
    ORIENTACAO_ESCOLAR("Orientação Escolar", CategoriaProcedimento.RELATORIO),
    ORIENTACAO_FAMILIAR("Orientação Familiar", CategoriaProcedimento.RELATORIO),
    ANAMNESE("Ficha de Anamnese", CategoriaProcedimento.RELATORIO),
    PLANEJAMENTO_TERAPEUTICO("Planejamento Terapêutico", CategoriaProcedimento.RELATORIO),
    RELATORIO_EVOLUTIVO("Relatório Evolutivo", CategoriaProcedimento.RELATORIO),
    RELATORIO_PERICIAL("Relatório Pericial", CategoriaProcedimento.RELATORIO),
    RELATORIO_PEDAGOGICO("Relatório Pedagógico", CategoriaProcedimento.RELATORIO),
    PLANO_INTERVENCAO_ESCOLAR("Plano de Intervenção Escolar", CategoriaProcedimento.RELATORIO),
    SUPERVISAO_CLINICA("Supervisão Clínica", CategoriaProcedimento.RELATORIO),
    EMISSAO_LAUDO("Emissão de Laudo", CategoriaProcedimento.RELATORIO),

    // 🗂️ ATIVIDADES ADMINISTRATIVAS
    REUNIAO_EQUIPE("Reunião de Equipe", CategoriaProcedimento.ADMINISTRATIVO),
    REUNIAO_ESCOLAR("Reunião Escolar", CategoriaProcedimento.ADMINISTRATIVO),
    SUPORTE_ESCOLAR("Suporte Escolar", CategoriaProcedimento.ADMINISTRATIVO),

    // 💵 TAXAS E COBRANÇAS
    TAXA_AGENDAMENTO("Taxa de Agendamento", CategoriaProcedimento.FINANCEIRO),
    TAXA_RELATORIO("Taxa de Relatório", CategoriaProcedimento.FINANCEIRO),

    // ❓ OUTROS
    OUTRO("Outro", CategoriaProcedimento.OUTRO);

    override fun toString(): String = descricao
}
