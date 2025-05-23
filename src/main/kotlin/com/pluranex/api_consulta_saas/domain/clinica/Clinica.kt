import com.pluranex.api_consulta_saas.domain.tenant.Tenant
import com.pluranex.api_consulta_saas.domain.enums.clinica.EspecialidadeClinica

data class Clinica(
    val id: Long? = null,
    val nome: String,
    val cnpj: String,
    val telefone: String?,
    val endereco: String,
    val especialidades: List<EspecialidadeClinica>,
    val empresa: Tenant
)
