package com.pluranex.api_consulta_saas.adapters.controllers

import com.pluranex.api_consulta_saas.adapters.dtos.tenant.TenantRequestDto
import com.pluranex.api_consulta_saas.adapters.dtos.tenant.TenantResponseDto
import com.pluranex.api_consulta_saas.common.annotations.RequirePermission
import com.pluranex.api_consulta_saas.common.session.enums.Permissao
import com.pluranex.api_consulta_saas.domain.tenant.TenantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tenants")
class TenantController(
    private val tenantService: TenantService
) {
    @RequirePermission(Permissao.GERENCIAR_TENANT)
    @PostMapping
    fun criarTenant(
        @RequestBody requestDto: TenantRequestDto
    ): ResponseEntity<TenantResponseDto> {
        val tenant = tenantService.criarNovoTenant(requestDto.nome)
        val response = TenantResponseDto.fromDomain(tenant)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{id}")
    fun buscarTenantPorId(
        @PathVariable id: Long
    ): ResponseEntity<TenantResponseDto> {
        val tenant = tenantService.buscarTenantPorId(id)
        val response = TenantResponseDto.fromDomain(tenant)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun listarTenants(): ResponseEntity<List<TenantResponseDto>> {
        val tenants = tenantService
            .listarTodosTenants()
            .map { TenantResponseDto.fromDomain(it) }

        return ResponseEntity.ok(tenants)
    }
}
