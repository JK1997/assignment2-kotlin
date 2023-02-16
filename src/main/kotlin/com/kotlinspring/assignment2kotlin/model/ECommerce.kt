package com.kotlinspring.assignment2kotlin.model

import lombok.*
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ECOMMERCE")
data class ECommerce(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int?,
        val invoiceNo: String? = null,
        val stockCode: String? = null,
        val description: String? = null,
        val quantity: Int? = null,
        val invoiceDate: LocalDate? = null,
        val unitPrice: BigDecimal? = null,
        val customerId: Int? = 0,
        val country: String? = null
        ){

}


