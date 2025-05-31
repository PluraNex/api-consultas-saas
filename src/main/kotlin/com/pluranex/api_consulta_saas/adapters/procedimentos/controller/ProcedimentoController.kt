package com.pluranex.api_consulta_saas.adapters.procedimentos.controller

import com.pluranex.api_consulta_saas.adapters.procedimento.dto.request.CriarProcedimentoRequest
import com.pluranex.api_consulta_saas.adapters.procedimento.dto.response.ProcedimentoResponse
import com.pluranex.api_consulta_saas.adapters.procedimentos.dto.CriarProcedimentoRequest
import com.pluranex.api_consulta_saas.domain.procedimento.ProcedimentoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/procedimentos")
class ProcedimentoController(
    private val procedimentoService: ProcedimentoService
) {

    @PostMapping
    fun criar(@RequestBody request: CriarProcedimentoRequest): ResponseEntity<ProcedimentoResponse> {
        val criado = procedimentoService.criarProcedimento(request.toDomain())
        return ResponseEntity.status(HttpStatus.CREATED).body(ProcedimentoResponse.fromDomain(criado))
    }

    @GetMapping("/tipos")
    fun listarTipos(): ResponseEntity<List<TipoProcedimentoResponse>> {
        val tipos = procedimentoService.listarTiposProcedimento()
        return ResponseEntity.ok(tipos.map { TipoProcedimentoResponse.fromEnum(it) })
    }
}

