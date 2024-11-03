package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.ProfissionalDto
import com.pluranex.api_consulta_saas.domain.services.ProfissionalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/profissionais")
class ProfissionalController(private val profissionalService: ProfissionalService) {

    @GetMapping
    fun listarProfissionais(): ResponseEntity<List<ProfissionalDto>> {
        val profissionais = profissionalService.listarTodosProfissionais()
        val response = profissionais.map { ProfissionalDto.fromDomain(it) }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun buscarProfissional(@PathVariable id: Long): ResponseEntity<ProfissionalDto> {
        val profissional = profissionalService.buscarProfissionalPorId(id)
        return if (profissional != null) {
            ResponseEntity.ok(ProfissionalDto.fromDomain(profissional))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun criarProfissional(@RequestBody dto: ProfissionalDto): ResponseEntity<ProfissionalDto> {
        val novoProfissional = profissionalService.criarNovoProfissional(
            nome = dto.nome,
            especialidade = dto.especialidade,
            telefone = dto.telefone,
            email = dto.email
        )
        return ResponseEntity.ok(ProfissionalDto.fromDomain(novoProfissional))
    }

    @PutMapping("/{id}")
    fun atualizarProfissional(
        @PathVariable id: Long,
        @RequestBody dto: ProfissionalDto
    ): ResponseEntity<ProfissionalDto> {
        val profissionalAtualizado = profissionalService.atualizarProfissional(
            id = id,
            nome = dto.nome,
            especialidade = dto.especialidade,
            telefone = dto.telefone,
            email = dto.email
        )
        return if (profissionalAtualizado != null) {
            ResponseEntity.ok(ProfissionalDto.fromDomain(profissionalAtualizado))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun excluirProfissional(@PathVariable id: Long): ResponseEntity<Void> {
        return if (profissionalService.excluirProfissional(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}