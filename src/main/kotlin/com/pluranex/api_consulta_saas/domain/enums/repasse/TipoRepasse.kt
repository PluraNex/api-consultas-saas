package com.pluranex.api_consulta_saas.domain.enums.repasse

/*Enumeração que define os tipos de repasse para procedimentos médicos
*
* @property PERCENTUAL Representa um repasse percentual, como 70% do valor do procedimento.
* @property FIXO Representa um repasse fixo, como R$ 50,00 por procedimento.
*/
enum class TipoRepasse {
    PERCENTUAL, // Ex: 70%
    FIXO        // Ex: R$ 50,00
}