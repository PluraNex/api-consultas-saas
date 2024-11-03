package com.pluranex.api_consulta_saas.domain.services

import com.pluranex.api_consulta_saas.domain.entities.Consulta
import com.pluranex.api_consulta_saas.domain.usecases.consulta.*
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ConsultaService(
    private val listarConsultas: ListarConsultas,
    private val criarConsulta: CriarConsulta,
    private val atualizarConsulta: AtualizarConsulta,
    private val confirmarConsulta: ConfirmarConsulta,
    private val cancelarConsulta: CancelarConsulta,
    private val finalizarConsulta: FinalizarConsulta,
    private val remarcarConsulta: RemarcarConsulta,
    private val listarConsultasPorPeriodo: ListarConsultasPorPeriodo,
    private val buscarConsultasPorPaciente: BuscarConsultasPorPaciente,
    private val buscarConsultasPorProfissional: BuscarConsultasPorProfissional,
    private val reagendarConsulta: ReagendarConsulta
//    private val notificacaoService: NotificacaoService, // Serviço de notificação
//    private val logService: LogService                   // Serviço de logging
) {

    fun listarTodasConsultas(): List<Consulta> = listarConsultas.execute()

    fun criarNovaConsulta(consulta: Consulta): Consulta = criarConsulta.execute(consulta)

    fun atualizarConsulta(consulta: Consulta): Consulta = atualizarConsulta.execute(consulta)

    fun confirmarConsulta(consultaId: Long): Consulta = confirmarConsulta.execute(consultaId)

    fun cancelarConsulta(consultaId: Long): Unit = cancelarConsulta.execute(consultaId)

    fun finalizarConsulta(consultaId: Long): Consulta = finalizarConsulta.execute(consultaId)

    fun remarcarConsultaComNotificacao(consultaId: Long, novaDataHorario: LocalDateTime): Consulta {
        val consultaRemarcada = remarcarConsulta.execute(consultaId, novaDataHorario)

//        notificacaoService.enviarNotificacao(
//            destinatario = consultaRemarcada.paciente.email,
//            mensagem = "Sua consulta foi remarcada para $novaDataHorario."
//        )
//        notificacaoService.enviarNotificacao(
//            destinatario = consultaRemarcada.profissional.email,
//            mensagem = "A consulta com ${consultaRemarcada.paciente.nome} foi remarcada para $novaDataHorario."
//        )
//
//        logService.registrarAtividade(
//            mensagem = "Consulta ID $consultaId remarcada para $novaDataHorario",
//            tipo = "REMARCACAO_CONSULTA"
//        )

        return consultaRemarcada
    }

    // Novo: Listar consultas por período
    fun listarConsultasNoPeriodo(start: LocalDateTime, end: LocalDateTime): List<Consulta> =
        listarConsultasPorPeriodo.execute(start, end)

    // Novo: Buscar consultas de um paciente específico
    fun buscarConsultasPorPaciente(pacienteId: Long): List<Consulta> =
        buscarConsultasPorPaciente.execute(pacienteId)

    // Novo: Buscar consultas de um profissional específico
    fun buscarConsultasPorProfissional(profissionalId: Long): List<Consulta> =
        buscarConsultasPorProfissional.execute(profissionalId)

    // Exemplo adicional: Reagendar consulta sem notificação (separando a lógica de notificação do use case)
    fun reagendarConsulta(dataAntiga: LocalDateTime, novaDataHorario: LocalDateTime): List<Consulta> {
        return reagendarConsulta.execute(dataAntiga, novaDataHorario)
    }
}
