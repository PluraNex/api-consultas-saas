package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.notificacao.NotificacaoRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.notificacao.NotificacaoResponseDto
import com.pluranex.api_consulta_saas.domain.enums.notificacao.CanalNotificacao
import com.pluranex.api_consulta_saas.domain.notificacao.Notificacao
import com.pluranex.api_consulta_saas.domain.notificacao.NotificacaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notificacoes")
class NotificacaoController(
        private val notificacaoService: NotificacaoService
) {


    @PostMapping
    fun criarNotificacao(@RequestBody requestDto: NotificacaoRequestDto): ResponseEntity<NotificacaoResponseDto> {
        val notificacao = notificacaoService.criarNotificacao(requestDto)
        val responseDto = NotificacaoResponseDto.fromDomain(notificacao)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
    }

    @GetMapping("/{id}")
    fun buscarNotificacao(@PathVariable id: Long): ResponseEntity<Notificacao> {
        val notificacao = notificacaoService.buscarNotificacao(id)
        return ResponseEntity.ok(notificacao)
    }

    @PutMapping("/{id}/enviar")
    fun enviarNotificacao(
            @PathVariable id: Long,
            @RequestParam canal: CanalNotificacao
    ): ResponseEntity<Notificacao> {
        val notificacao = notificacaoService.enviarNotificacao(id, canal)
        return ResponseEntity.ok(notificacao)
    }

    @PutMapping("/{id}/reenviar")
    fun reenviarNotificacao(
            @PathVariable id: Long,
            @RequestParam canal: CanalNotificacao
    ): ResponseEntity<Notificacao> {
        val notificacao = notificacaoService.reenviarNotificacao(id, canal)
        return ResponseEntity.ok(notificacao)
    }

    @GetMapping
    fun listarNotificacoes(): ResponseEntity<List<Notificacao>> {
        val notificacoes = notificacaoService.listarNotificacoes()
        return ResponseEntity.ok(notificacoes)
    }

    @DeleteMapping("/{id}")
    fun removerNotificacao(@PathVariable id: Long): ResponseEntity<Void> {
        notificacaoService.removerNotificacao(id)
        return ResponseEntity.noContent().build()
    }
}
