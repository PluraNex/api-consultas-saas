package com.pluranex.api_consulta_saas.infrastructure.security.aspect

import com.pluranex.api_consulta_saas.common.annotations.RequirePlan
import com.pluranex.api_consulta_saas.common.session.core.SessaoUsuario
import com.pluranex.api_consulta_saas.domain.enums.plano.PlanoTenant
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException.BusinessExceptionType
import com.pluranex.api_consulta_saas.domain.exceptions.PermissionException
import com.pluranex.api_consulta_saas.domain.exceptions.PermissionException.PermissionExceptionType.PERMISSAO_NEGADA
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

/**
 * Aspecto responsável por validar se a funcionalidade anotada com [RequirePlan]
 * está sendo acessada por um tenant com plano compatível.
 *
 * Executado antes de métodos anotados com [@RequirePlan], compara o plano da sessão
 * com os planos permitidos e lança exceções apropriadas caso não haja compatibilidade.
 */
@Aspect
@Component
class RequirePlanAspect {

    private val logger = LoggerFactory.getLogger(RequirePlanAspect::class.java)

    /**
     * Executa a validação de plano antes do método anotado com [@RequirePlan].
     *
     * @param requirePlan Anotação contendo os planos permitidos.
     * @throws PermissionException Se a sessão for inválida.
     * @throws BusinessException Se o plano do tenant não estiver entre os permitidos.
     */
    @Before("@annotation(requirePlan)")
    fun checkPlan(requirePlan: RequirePlan) {
        val auth = SecurityContextHolder.getContext().authentication
        val sessao = auth.principal as? SessaoUsuario
            ?: throw PermissionException(
                PERMISSAO_NEGADA,
                "Sessão inválida ou não autenticada."
            )

        val planoAtual: PlanoTenant = sessao.contexto.plano.tipo
        val planosPermitidos = requirePlan.allowed.toSet()

        if (planosPermitidos.isEmpty()) {
            throw IllegalArgumentException("@RequirePlan deve declarar ao menos um plano permitido")
        }

        if (planoAtual !in planosPermitidos) {
            logger.warn(
                "Acesso negado: plano atual '$planoAtual' não está entre os permitidos: ${planosPermitidos.joinToString()}"
            )
            throw BusinessException(
                BusinessExceptionType.PLANO_NAO_PERMITIDO,
                "A funcionalidade requer plano(s): ${planosPermitidos.joinToString()}. Plano atual: $planoAtual"
            )
        }
    }
}
