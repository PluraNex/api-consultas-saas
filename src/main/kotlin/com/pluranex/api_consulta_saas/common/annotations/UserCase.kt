package com.pluranex.api_consulta_saas.common.annotations


import org.springframework.stereotype.Component

/**
 * Indica que a classe representa um caso de uso (Use Case)
 * de acordo com os princípios da Clean Architecture.
 * A anotação é utilizada para identificar classes que implementam
 * a lógica de negócios e são responsáveis por orquestrar as operações
 * entre os componentes do sistema.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class UseCase
