package com.pluranex.api_consulta_saas.infrastructure.repositories.paciente

import com.pluranex.api_consulta_saas.domain.entities.Paciente
import com.pluranex.api_consulta_saas.infrastructure.mappers.PacienteMapper
import org.springframework.stereotype.Repository

@Repository
class PacienteRepository(private val pacienteJpaRepository: PacienteJpaRepository) {

    fun listarPacientes(): List<Paciente> =
        pacienteJpaRepository.findAll().map { PacienteMapper.toDomain(it) }

    fun buscarPacientePorId(id: Long): Paciente? =
        pacienteJpaRepository.findById(id).orElse(null)?.let { PacienteMapper.toDomain(it) }

    fun criarPaciente(paciente: Paciente): Paciente =
        PacienteMapper.toDomain(pacienteJpaRepository.save(PacienteMapper.toModel(paciente)))

    fun atualizarPaciente(pacienteId: Long, paciente: Paciente): Paciente? {
        val pacienteExistente = pacienteJpaRepository.findById(pacienteId).orElse(null) ?: return null
        val atualizado = pacienteExistente.copy(
            nome = paciente.nome,
            telefone = paciente.telefone,
            email = paciente.email
        )
        return PacienteMapper.toDomain(pacienteJpaRepository.save(atualizado))
    }

    fun excluirPaciente(pacienteId: Long): Boolean {
        return if (pacienteJpaRepository.existsById(pacienteId)) {
            pacienteJpaRepository.deleteById(pacienteId)
            true
        } else {
            false
        }
    }
}