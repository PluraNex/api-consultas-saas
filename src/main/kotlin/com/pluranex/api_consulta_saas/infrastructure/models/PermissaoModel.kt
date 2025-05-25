// infrastructure/models/PermissaoModel.kt
package com.pluranex.api_consulta_saas.infrastructure.models

import com.pluranex.api_consulta_saas.domain.enums.permissao.EscopoPermissao
import com.pluranex.api_consulta_saas.domain.enums.permissao.Permissao
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "permissoes_usuario")
data class PermissaoModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuario: UsuarioModel,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val permissao: Permissao,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val escopo: EscopoPermissao = EscopoPermissao.LOCAL,

    val atribuidaPor: String? = null,

    val atribuidaEm: LocalDateTime = LocalDateTime.now()
)