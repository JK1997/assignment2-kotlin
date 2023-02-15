package com.kotlinspring.assignment2kotlin.controller

import com.kotlinspring.assignment2kotlin.model.ECommerce
import com.kotlinspring.assignment2kotlin.service.ECommerceService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController

class ECommerceController(val eCommerceService: ECommerceService) {
    @GetMapping("/{name}")
    fun retrieveData(@PathVariable("name") name: String): String {
        return "Hello $name"
    }

    @PostMapping(path = ["/uploads"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun postEcommerceData(@RequestParam("file") file: MultipartFile) {
        file.inputStream.use {
            eCommerceService.saveECommerceList(it)
        }
    }
}

