package com.pluranex.api_consulta_saas.domain.politica.shared

/**
 * Interface base para todos os serviços de política aplicáveis a um domínio específico.
 *
 * Esta interface não define métodos, apenas marca e categoriza os serviços de política
 * como componentes do sistema que expõem regras de negócio dinâmicas, variáveis por tenant,
 * perfil ou contexto institucional.
 *
 * Exemplos concretos:
 * - [ProcedimentoPolicyService]
 * - [ClinicaPolicyService]
 * - [PacientePolicyService]
 */
interface PolicyService
