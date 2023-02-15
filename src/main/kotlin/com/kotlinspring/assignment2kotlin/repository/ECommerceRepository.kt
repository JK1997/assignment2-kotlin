package com.kotlinspring.assignment2kotlin.repository


import com.kotlinspring.assignment2kotlin.model.ECommerce
import org.springframework.data.repository.CrudRepository

interface ECommerceRepository: CrudRepository<ECommerce, Int> {
}

