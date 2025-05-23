package com.pluranex.api_consulta_saas.domain.tenant.validation

import com.pluranex.api_consulta_saas.domain.exceptions.BusinessException
import org.springframework.stereotype.Service

@Service
class TenantValidatorImpl : TenantValidator {

    override fun validarNome(nome: String) {
        if (nome.isBlank()) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.EMPRESA_NOME_INVALIDO,
                "O nome da empresa de saúde não pode ser vazio."
            )
        }

        if (nome.length < 3) {
            throw BusinessException(
                BusinessException.BusinessExceptionType.EMPRESA_NOME_INVALIDO,
                "O nome da empresa de saúde deve conter ao menos 3 caracteres."
            )
        }
    }
}
