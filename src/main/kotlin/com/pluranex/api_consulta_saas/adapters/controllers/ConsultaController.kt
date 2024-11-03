package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.ConsultaDto
import com.pluranex.api_consulta_saas.domain.services.ConsultaService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/consultas")
class ConsultaController(private val consultaService: ConsultaService) {

    @GetMapping
    fun listarConsultas(): ResponseEntity<List<ConsultaDto>> {
        val consultas = consultaService.listarTodasConsultas().map { ConsultaDto.fromDomain(it) }
        return ResponseEntity.ok(consultas)
    }

//    @PostMapping
//    fun criarConsulta(@RequestBody consultaRequest: ConsultaRequestDto): ResponseEntity<ConsultaDto> {
//        val consulta = consultaService.criarNovaConsulta(
//            consultaRequest.toDomain()
//        )
//        return ResponseEntity.ok(ConsultaDto.fromDomain(consulta))
//    }

//    @PutMapping("/{consultaId}")
//    fun atualizarConsulta(
//        @PathVariable consultaId: Long,
//        @RequestBody consultaRequest: ConsultaRequestDto
//    ): ResponseEntity<ConsultaDto> {
//        val consulta = consultaService.atualizarConsulta(
//            consultaRequest.toDomain(consultaId)
//        )
//        return ResponseEntity.ok(ConsultaDto.fromDomain(consulta))
//    }

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

    @PutMapping("/{consultaId}/remarcar")
    fun remarcarConsulta(
        @PathVariable consultaId: Long,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) novaDataHorario: LocalDateTime
    ): ResponseEntity<ConsultaDto> {
        val consulta = consultaService.remarcarConsultaComNotificacao(consultaId, novaDataHorario)
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
