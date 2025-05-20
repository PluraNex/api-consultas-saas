package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.empresa.EmpresaSaudeRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.empresa.EmpresaSaudeResponseDto
import com.pluranex.api_consulta_saas.domain.empresa.EmpresaSaudeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/empresas-saude")
class EmpresaSaudeController(
    private val empresaSaudeService: EmpresaSaudeService
) {

    @PostMapping
    fun criarEmpresa(
        @RequestBody requestDto: EmpresaSaudeRequestDto
    ): ResponseEntity<EmpresaSaudeResponseDto> {
        val empresa = empresaSaudeService.criarNovaEmpresaSaude(requestDto.nome)
        val response = EmpresaSaudeResponseDto.fromDomain(empresa)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{id}")
    fun buscarEmpresaPorId(
        @PathVariable id: Long
    ): ResponseEntity<EmpresaSaudeResponseDto> {
        val empresa = empresaSaudeService.buscarEmpresaSaudePorId(id)
        val response = EmpresaSaudeResponseDto.fromDomain(empresa)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun listarEmpresas(): ResponseEntity<List<EmpresaSaudeResponseDto>> {
        val empresas = empresaSaudeService
            .listarTodasEmpresasSaude()
            .map { EmpresaSaudeResponseDto.fromDomain(it) }

        return ResponseEntity.ok(empresas)
    }
}
