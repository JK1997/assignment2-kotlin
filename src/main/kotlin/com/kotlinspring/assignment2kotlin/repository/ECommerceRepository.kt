package com.kotlinspring.assignment2kotlin.repository


import com.kotlinspring.assignment2kotlin.model.ECommerce
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ECommerceRepository : JpaRepository<ECommerce, Int> {
    @Query(
        value = "SELECT * FROM ECOMMERCE WHERE (country ilike %?1% " +
                "OR customer_id ilike %?1% OR description ilike %?1% " +
                "OR invoice_no ilike %?1% OR quantity ilike %?1% " +
                "OR stock_code ilike %?1% OR unit_price ilike %?1%)",
        nativeQuery = true
    )
    fun findECommerceBySearchQuery(searchQuery: String, pageable: Pageable): Page<ECommerce>

}

