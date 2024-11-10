package com.pluranex.api_consulta_saas.application.profissional
import com.pluranex.api_consulta_saas.domain.exceptions.NotFoundException
import com.pluranex.api_consulta_saas.domain.profissional.Profissional
import com.pluranex.api_consulta_saas.domain.profissional.usercases.*
import com.pluranex.api_consulta_saas.domain.services.ProfissionalService
import org.springframework.stereotype.Service

@Service
class ProfissionalServiceImpl(
    private val listarProfissionais: ListarProfissionais,
    private val buscarProfissional: BuscarProfissional,
    private val criarProfissional: CriarProfissional,
    private val atualizarProfissional: AtualizarProfissional,
    private val excluirProfissional: ExcluirProfissional
) : ProfissionalService {

    override fun listarTodosProfissionais(): List<Profissional> {
        return listarProfissionais.execute()
    }

    override fun buscarProfissionalPorId(id: Long): Profissional {
        return buscarProfissional.execute(id)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.PROFISSIONAL_NOT_FOUND,
                "Profissional com ID $id não encontrado."
            )
    }

    override fun criarNovoProfissional(nome: String, especialidade: String, telefone: String, email: String?): Profissional {
        return criarProfissional.execute(nome, especialidade, telefone, email)
    }

    override fun atualizarProfissional(id: Long, nome: String, especialidade: String, telefone: String, email: String?): Profissional {
        return atualizarProfissional.execute(id, nome, especialidade, telefone, email)
            ?: throw NotFoundException(
                NotFoundException.NotFoundExceptionType.PROFISSIONAL_NOT_FOUND,
                "Profissional com ID $id não encontrado para atualização."
            )
    }

    override fun excluirProfissional(id: Long): Boolean {
        return excluirProfissional.execute(id)
    }
}
