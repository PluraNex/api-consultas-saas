package com.pluranex.api_consulta_saas.domain.consulta.usecase

import com.pluranex.api_consulta_saas.domain.consulta.Consulta
import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.enums.consulta.StatusConsulta
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.consulta.ConsultaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AtualizarConsulta(private val consultaRepository: ConsultaRepository) {

    fun execute(consulta: Consulta, novoProfissional: Profissional?, dataHorario: LocalDateTime?, observacoes: String?): Consulta {
        // Validação: Não permitir atualizar uma consulta finalizada
        if (consulta.status == StatusConsulta.FINALIZADA) {
            throw BusinessException(BusinessException.BusinessExceptionType.CONSULTA_FINALIZADA, "A consulta já foi finalizada e não pode ser modificada.")
        }

        // Validação: Não permitir atualizar uma consulta cancelada
        if (consulta.status == StatusConsulta.CANCELADA) {
            throw BusinessException(BusinessException.BusinessExceptionType.CONSULTA_JA_CANCELADA, "A consulta já foi cancelada e não pode ser reagendada.")
        }

        // Atualizar o profissional, se fornecido
        novoProfissional?.let {
            consulta.profissional = it
        }

        // Atualizar a data/hora, se fornecida
        dataHorario?.let {
            if (it.isBefore(LocalDateTime.now())) {
                throw BusinessException(BusinessException.BusinessExceptionType.HORARIO_INDISPONIVEL, "A data/hora da consulta não pode ser no passado.")
            }
            consulta.dataHorario = it
        }

        // Atualizar observações, se fornecidas
        observacoes?.let {
            consulta.observacoes = it
        }

        // Persistir a consulta atualizada
        return consultaRepository.atualizarConsulta(consulta)
    }
}