package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.PacienteDto
import com.pluranex.api_consulta_saas.domain.paciente.PacienteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pacientes")
class PacienteController(private val pacienteService: PacienteService) {

    @GetMapping
    fun listarPacientes(): List<PacienteDto> {
        return pacienteService.listarTodosPacientes().map { PacienteDto.fromDomain(it) }
    }

    @GetMapping("/{id}")
    fun buscarPaciente(@PathVariable id: Long): PacienteDto? {
        return pacienteService.buscarPacientePorId(id).let { PacienteDto.fromDomain(it) }
    }

    @PostMapping
    fun criarPaciente(@RequestBody dto: PacienteDto): PacienteDto {
        val paciente = pacienteService.criarNovoPaciente(dto.nome, dto.telefone, dto.email)
        return PacienteDto.fromDomain(paciente)
    }

    @PutMapping("/{id}")
    fun atualizarPaciente(@PathVariable id: Long, @RequestBody dto: PacienteDto): PacienteDto? {
        return pacienteService.atualizarPaciente(id, dto.nome, dto.telefone, dto.email).let { PacienteDto.fromDomain(it) }
    }

    @DeleteMapping("/{id}")
    fun excluirPaciente(@PathVariable id: Long): Boolean {
        return pacienteService.excluirPaciente(id)
    }
}