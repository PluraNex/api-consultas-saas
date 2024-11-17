package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaDto
import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaUpdateDto
import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/consultas")
class ConsultaController(
    private val consultaService: ConsultaService

) {

    @GetMapping
    fun listarConsultas(): ResponseEntity<List<ConsultaDto>> {
        val consultas = consultaService.listarTodasConsultas().map { ConsultaDto.fromDomain(it) }
        return ResponseEntity.ok(consultas)
    }

    @PostMapping
    fun criarConsulta(@RequestBody consultaRequestDto: ConsultaRequestDto): ResponseEntity<Consulta> {
        val novaConsulta = consultaService.criarNovaConsulta(consultaRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta)
    }

    @PatchMapping("/{consultaId}")
    fun atualizarConsultaParcial(
        @PathVariable consultaId: Long,
        @RequestBody consultaUpdateDto: ConsultaUpdateDto
    ): ResponseEntity<ConsultaDto> {
        val consultaAtualizada = consultaService.atualizarConsulta(consultaId, consultaUpdateDto)
        return ResponseEntity.ok(ConsultaDto.fromDomain(consultaAtualizada))
    }

    @PutMapping("/{consultaId}/confirmar")
    fun confirmarConsulta(@PathVariable consultaId: Long): ResponseEntity<ConsultaDto> {
        val consulta = consultaService.confirmarConsulta(consultaId)
        return ResponseEntity.ok(ConsultaDto.fromDomain(consulta))
    }

    @PutMapping("/{consultaId}/cancelar")
    fun cancelarConsulta(@PathVariable consultaId: Long): ResponseEntity<Void> {
        consultaService.cancelarConsulta(consultaId)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{consultaId}/finalizar")
    fun finalizarConsulta(@PathVariable consultaId: Long): ResponseEntity<ConsultaDto> {
        val consulta = consultaService.finalizarConsulta(consultaId)
        return ResponseEntity.ok(ConsultaDto.fromDomain(consulta))
    }

    @GetMapping("/periodo")
    fun listarConsultasPorPeriodo(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) start: LocalDateTime,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) end: LocalDateTime
    ): ResponseEntity<List<ConsultaDto>> {
        val consultas = consultaService.listarConsultasNoPeriodo(start, end)
            .map { ConsultaDto.fromDomain(it) }
        return ResponseEntity.ok(consultas)
    }

    @GetMapping("/paciente/{pacienteId}")
    fun buscarConsultasPorPaciente(@PathVariable pacienteId: Long): ResponseEntity<List<ConsultaDto>> {
        val consultas = consultaService.buscarConsultasPorPaciente(pacienteId)
            .map { ConsultaDto.fromDomain(it) }
        return ResponseEntity.ok(consultas)
    }

    @GetMapping("/profissional/{profissionalId}")
    fun buscarConsultasPorProfissional(@PathVariable profissionalId: Long): ResponseEntity<List<ConsultaDto>> {
        val consultas = consultaService.buscarConsultasPorProfissional(profissionalId)
            .map { ConsultaDto.fromDomain(it) }
        return ResponseEntity.ok(consultas)
    }
}
