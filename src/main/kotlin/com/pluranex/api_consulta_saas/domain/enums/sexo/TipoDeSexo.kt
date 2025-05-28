package com.pluranex.api_consulta_saas.domain.enums.sexo

/**
 * Enumeração que representa os tipos possíveis de sexo ou identidade de gênero
 * reconhecidos em contextos clínicos e legais, de acordo com práticas inclusivas
 * e políticas de diversidade de gênero adotadas por órgãos de saúde.
 *
 * Esta estrutura é utilizada em conjunto com o value class [Sexo] para garantir
 * clareza semântica, integridade de domínio e suporte a contextos multiclínica
 * com pacientes autodeclarados conforme a legislação vigente (ex: Resolução
 * nº 2.265/2019 do CFM, políticas da ANS e diretrizes do SUS).
 *
 * ### Responsabilidades:
 * - Representar valores controlados e inclusivos para campo de sexo/gênero.
 * - Ser exibido em interfaces amigáveis por meio de `toString()`.
 * - Ser referenciado de forma segura e imutável via value objects.
 *
 * ### Exemplo de uso:
 * ```
 * val sexo = Sexo(TipoDeSexo.TRANS_MASCULINO)
 * println(sexo) // Trans masculino
 * ```
 *
 * @property descricao Valor formatado para exibição pública em telas ou documentos.
 */
enum class TipoDeSexo(private val descricao: String) {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    INTERSEXO("Intersexo"),
    TRANS_MASCULINO("Trans masculino"),
    TRANS_FEMININO("Trans feminino"),
    NAO_BINARIO("Não binário"),
    OUTRO("Outro"),
    PREFERE_NAO_INFORMAR("Prefere não informar");

    override fun toString(): String = descricao
}
