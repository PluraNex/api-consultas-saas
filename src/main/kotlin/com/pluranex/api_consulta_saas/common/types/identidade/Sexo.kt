package com.pluranex.api_consulta_saas.common.types.identidade

import com.pluranex.api_consulta_saas.domain.enums.sexo.TipoDeSexo
import java.io.Serializable
import java.util.Locale

/**
 * Value Object que representa o sexo ou identidade de gênero de um paciente,
 * garantindo integridade e segurança de domínio no sistema clínico multi-tenant.
 *
 * Utiliza o enum [TipoDeSexo] internamente e expõe métodos auxiliares para validação,
 * exibição e lógica de negócio relacionada à diversidade de gênero e inclusão.
 *
 * ### Responsabilidades:
 * - Encapsular e validar o valor do tipo [TipoDeSexo].
 * - Fornecer conversão segura a partir de descrições de entrada.
 * - Suportar lógica de negócio como política de visibilidade, divergência biológica etc.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val sexo = Sexo(TipoDeSexo.TRANS_MASCULINO)
 * println(sexo) // Trans masculino
 *
 * val outro = Sexo.fromDescricao("Não binário") ?: Sexo(TipoDeSexo.PREFERE_NAO_INFORMAR)
 * ```
 */
@JvmInline
value class Sexo(val value: TipoDeSexo) : Serializable {

    init {
        require(value in TipoDeSexo.entries) { "Sexo inválido: $value" }
    }

    override fun toString(): String = value.toString()

    companion object {
        /**
         * Constrói uma instância de [Sexo] a partir de uma descrição textual amigável.
         *
         * @param descricao Descrição textual (ex: “Masculino”, “Trans feminino”).
         * @return Instância segura de [Sexo] ou `null` se inválido.
         */
        fun fromDescricao(descricao: String): Sexo? =
            TipoDeSexo.entries.firstOrNull {
                it.toString().equals(descricao, ignoreCase = true)
            }?.let { Sexo(it) }
    }

    /**
     * Verifica se o valor é diferente de "Prefere não informar".
     */
    fun isInformado(): Boolean = value != TipoDeSexo.PREFERE_NAO_INFORMAR

    /**
     * Verifica se o sexo informado representa uma identidade divergente de um sexo biológico.
     */
    fun isDivergenteDoBiologico(sexoBiologico: TipoDeSexo): Boolean =
        value != sexoBiologico && value !in listOf(TipoDeSexo.OUTRO, TipoDeSexo.PREFERE_NAO_INFORMAR)

    /**
     * Verifica se o valor é adequado para relatórios oficiais (excluindo "Outro" e "Prefere não informar").
     */
    fun isValidoParaRelatorio(): Boolean =
        value !in listOf(TipoDeSexo.OUTRO, TipoDeSexo.PREFERE_NAO_INFORMAR)

    /**
     * Gera um pronome padrão simplificado com base na identidade.
     */
    fun pronome(): String = when (value) {
        TipoDeSexo.MASCULINO, TipoDeSexo.TRANS_MASCULINO -> "ele"
        TipoDeSexo.FEMININO, TipoDeSexo.TRANS_FEMININO -> "ela"
        TipoDeSexo.NAO_BINARIO, TipoDeSexo.INTERSEXO -> "elu"
        else -> "neutro"
    }

    /**
     * Exibe a descrição localizada (futuro suporte multi-idioma).
     */
    fun descricao(locale: Locale = Locale.getDefault()): String = value.toString()

    /**
     * Verifica se a identidade de gênero está permitida na clínica atual.
     *
     * @param permitidos Lista de tipos permitidos pelo tenant.
     * @return `true` se o valor atual está na lista de permitidos.
     */
    fun permitidoPeloTenant(permitidos: Set<TipoDeSexo>): Boolean = value in permitidos

    /**
     * Verifica se o sexo deve ser ocultado em contextos sensíveis (ex: pediatria).
     */
    fun deveOcultarParaContextoEspecial(): Boolean =
        value in listOf(TipoDeSexo.OUTRO, TipoDeSexo.PREFERE_NAO_INFORMAR)
}
