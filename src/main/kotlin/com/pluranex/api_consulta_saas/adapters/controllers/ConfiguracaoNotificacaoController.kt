package com.pluranex.api_consulta_saas.adapters.controllers

import ConfiguracaoNotificacaoResponseDto
import com.pluranex.api_consulta_saas.adapters.dtos.configuracao_notificacao.ConfiguracaoNotificacaoRequestDto
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacao
import com.pluranex.api_consulta_saas.domain.configuracao_notificacao.ConfiguracaoNotificacaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/configuracoes-notificacao")
class ConfiguracaoNotificacaoController(
    private val configuracaoNotificacaoService: ConfiguracaoNotificacaoService
) {

    @PostMapping
    fun criarConfiguracao(
        @RequestBody configuracao: ConfiguracaoNotificacao,
        @RequestParam notificacaoId: Long
    ): ResponseEntity<ConfiguracaoNotificacao> {
        val novaConfiguracao = configuracaoNotificacaoService.criarConfiguracao(configuracao, notificacaoId)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConfiguracao)
    }

    @PutMapping("/{id}")
    fun atualizarConfiguracao(
        @RequestParam notificacaoId: Long,
        @RequestBody novaConfiguracao: ConfiguracaoNotificacao
    ): ResponseEntity<ConfiguracaoNotificacao> {
        val configuracaoAtualizada = configuracaoNotificacaoService.atualizarConfiguracao(novaConfiguracao, notificacaoId)
        return ResponseEntity.ok(configuracaoAtualizada)
    }


    @DeleteMapping("/{id}")
    fun removerConfiguracao(@PathVariable id: Long): ResponseEntity<Void> {
        configuracaoNotificacaoService.removerConfiguracao(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun buscarConfiguracao(@PathVariable id: Long): ResponseEntity<ConfiguracaoNotificacao> {
        val configuracao = configuracaoNotificacaoService.buscarConfiguracao(id)
        return ResponseEntity.ok(configuracao)
    }

    @GetMapping
    fun listarConfiguracoes(): ResponseEntity<List<ConfiguracaoNotificacao>> {
        val configuracoes = configuracaoNotificacaoService.listarConfiguracoes()
        return ResponseEntity.ok(configuracoes)
    }

    @PostMapping("/default")
    fun definirConfiguracaoDefault(@RequestBody dto: ConfiguracaoNotificacaoRequestDto): ResponseEntity<ConfiguracaoNotificacaoResponseDto> {
        val configuracaoDefault = configuracaoNotificacaoService.definirConfiguracaoDefault(dto)
        val responseDto = ConfiguracaoNotificacaoResponseDto.fromDomain(configuracaoDefault)
        return ResponseEntity.ok(responseDto)
    }


    @GetMapping("/default")
    fun obterConfiguracaoDefault(): ResponseEntity<ConfiguracaoNotificacao> {
        val configuracaoDefault = configuracaoNotificacaoService.obterConfiguracaoDefault()
        return ResponseEntity.ok(configuracaoDefault)
    }
}
