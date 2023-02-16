package com.kotlinspring.assignment2kotlin.dto

import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ECommerceDTO(
        val id: Int?,
        @get:NotBlank(message = "ECommerceDTO.invoiceNo must not be blank")
        val invoiceNo: String,
        @get:NotBlank(message = "ECommerceDTO.stockCode must not be blank")
        val stockCode: String,
        @get:NotBlank(message = "ECommerceDTO.description must not be blank")
        val description: String,
        @get:NotBlank(message = "ECommerceDTO.quantity must not be blank")
        val quantity: Int,
        @get:NotBlank(message = "ECommerceDTO.invoiceDate must not be blank")
        val invoiceDate: LocalDate,
        @get:NotBlank(message = "ECommerceDTO.unitPrice must not be blank")
        val unitPrice: BigDecimal,
        @get:NotBlank(message = "ECommerceDTO.customerId must not be blank")
        val customerId: Int,
        @get:NotBlank(message = "ECommerceDTO.country must not be blank")
        val country: String,
)