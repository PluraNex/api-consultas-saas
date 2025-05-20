package com.pluranex.api_consulta_saas.application.consulta

import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.consulta.ConsultaUpdateDto
import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.consulta.usecase.*
import com.pluranex.api_consulta_saas.domain.paciente.PacienteService
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaService
import com.pluranex.api_consulta_saas.domain.services.ProfissionalService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ConsultaServiceImpl(
    private val listarConsultas: ListarConsultas,
    private val criarConsulta: CriarConsulta,
    private val atualizarConsulta: AtualizarConsulta,
    private val confirmarConsulta: ConfirmarConsulta,
    private val cancelarConsulta: CancelarConsulta,
    private val finalizarConsulta: FinalizarConsulta,
    private val buscarConsulta: BuscarConsulta,
    private val listarConsultasPorPeriodo: ListarConsultasPorPeriodo,
    private val buscarConsultasPorPaciente: BuscarConsultasPorPaciente,
    private val buscarConsultasPorProfissional: BuscarConsultasPorProfissional,
    private val reagendarConsulta: ReagendarConsulta,
    private val pacienteService: PacienteService,
    private val profissionalService: ProfissionalService
) : ConsultaService {

    override fun listarTodasConsultas(): List<Consulta> = listarConsultas.execute()

    override fun criarNovaConsulta(consultaRequestDto: ConsultaRequestDto): Consulta {
        val paciente = pacienteService.buscarPacientePorId(consultaRequestDto.pacienteId)
        val profissional = profissionalService.buscarProfissionalPorId(consultaRequestDto.profissionalId)
        val consulta = consultaRequestDto.toDomain(paciente, profissional)
        return criarConsulta.execute(consulta)
    }

    override fun atualizarConsulta(id: Long, consultaUpdateDto: ConsultaUpdateDto): Consulta {
        val consultaExistente = buscarConsulta.execute(id)

        val novoProfissional = consultaUpdateDto.profissionalId?.let {
            profissionalService.buscarProfissionalPorId(it)
        }

        return atualizarConsulta.execute(
            consultaExistente,
            novoProfissional,
            consultaUpdateDto.dataHorario,
            consultaUpdateDto.observacoes
        )
    }

    override fun confirmarConsulta(consultaId: Long): Consulta = confirmarConsulta.execute(consultaId)

    override fun cancelarConsulta(consultaId: Long) {
        cancelarConsulta.execute(consultaId)
    }

    override fun finalizarConsulta(consultaId: Long): Consulta = finalizarConsulta.execute(consultaId)

    override fun listarConsultasNoPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta> =
        listarConsultasPorPeriodo.execute(start, end)

    override fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta> =
        buscarConsultasPorPaciente.execute(pacienteId)

    override fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta> =
        buscarConsultasPorProfissional.execute(profissionalId)

    override fun reagendarConsulta(dataAntiga: LocalDateTime, novaDataHorario: LocalDateTime): List<Consulta> {
        return reagendarConsulta.execute(dataAntiga, novaDataHorario)
    }
}
