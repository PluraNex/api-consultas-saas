package com.pluranex.api_consulta_saas.domain.crm.contato

import com.pluranex.api_consulta_saas.domain.contato.MeiosContato
import java.time.LocalDateTime

/**
 * Representa uma pessoa ou entidade dentro do módulo de CRM com dados estratégicos
 * para relacionamento, notificações, campanhas e segmentações.
 *
 * Esta estrutura é composta por informações identificadoras e pelos meios de contato,
 * além de permitir rastrear a criação, estado e classificação da pessoa relacionada.
 *
 * ### Responsabilidades:
 * - Armazenar os dados de contato da pessoa (nome + meios).
 * - Classificar o contato com tags livres e observações.
 * - Permitir controle de ativação e auditoria básica.
 *
 * ### Exemplo de uso:
 * ```kotlin
 * val contato = ContatoCrm(
 *     nomeCompleto = "João da Silva",
 *     meios = MeiosContato("83999999999", "joao@email.com", "83999999999"),
 *     observacao = "Paciente VIP",
 *     tags = setOf("VIP", "Indicação"),
 *     criadoPor = "admin@clinica.com"
 * )
 * ```
 *
 * @property nomeCompleto Nome completo da pessoa ou representante.
 * @property meios Meios de contato para comunicações e notificações.
 * @property observacao Comentário ou anotação relevante.
 * @property tags Etiquetas classificadoras (ex: VIP, bloqueado, campanha).
 * @property ativo Indica se o contato está ativo para comunicações.
 * @property criadoEm Timestamp da criação do registro.
 * @property criadoPor Identificador do usuário ou sistema que criou o contato.
 */
data class ContatoCrm(
    val nomeCompleto: String,
    val meios: MeiosContato,
    val observacao: String? = null,
    val tags: Set<String> = emptySet(),
    val ativo: Boolean = true,
    val criadoEm: LocalDateTime = LocalDateTime.now(),
    val criadoPor: String? = null
)