package com.kotlinspring.assignment2kotlin.repository


import com.kotlinspring.assignment2kotlin.model.ECommerce
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ECommerceRepository: JpaRepository<ECommerce, Int> {

}

