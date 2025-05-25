package com.pluranex.api_consulta_saas.domain.clinica

import com.pluranex.api_consulta_saas.domain.contato.MeiosContato
import com.pluranex.api_consulta_saas.common.types.identidade.Cnpj
import com.pluranex.api_consulta_saas.common.types.tenant.TenantId
import com.pluranex.api_consulta_saas.domain.endereco.Endereco
import com.pluranex.api_consulta_saas.domain.enums.clinica.EspecialidadeClinica

/**
 * Representa uma unidade clínica dentro de um tenant do sistema.
 *
 * Cada clínica possui CNPJ, endereço, especialidades e meios de contato institucionais.
 *
 * @property id Identificador interno da clínica.
 * @property nome Nome fantasia da clínica.
 * @property cnpj CNPJ da unidade.
 * @property contato Meios institucionais de contato.
 * @property endereco Endereço físico da clínica.
 * @property especialidades Especialidades médicas atendidas na unidade.
 * @property tenantId Identificador do tenant (empresa) ao qual a clínica pertence.
 */
data class Clinica(
    val id: Long? = null,
    val tenantId: TenantId,
    val nome: String,
    val cnpj: Cnpj,
    val contato: MeiosContato,
    val endereco: Endereco,
    val especialidades: List<EspecialidadeClinica>,
)