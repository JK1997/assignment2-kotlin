package com.kotlinspring.assignment2kotlin.controller

import com.kotlinspring.assignment2kotlin.model.ECommerce
import com.kotlinspring.assignment2kotlin.service.ECommerceService
import mu.KLogging
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class ECommerceController(val eCommerceService: ECommerceService) {
    companion object : KLogging()

    @PostMapping(path = ["/uploads"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun postEcommerceData(@RequestParam("file") file: MultipartFile) {
        logger.info("postEcommerceData Begin | file type: ${file.contentType}")
        //use - Executes the given block function on this resource and then closes it down correctly whether an exception is thrown or not.
        file.inputStream.use {
            eCommerceService.saveECommerceList(it, file)
        }
        logger.info("postEcommerceData End | file type: ${file.contentType}")
    }

    @GetMapping("/getAllECommerce")
    fun retrieveAllECommerceData(
        @RequestParam(name = "searchQuery", required = false) searchQuery: String?,
        @RequestParam(name = "sort", defaultValue = "+id") sort: String,
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "size", defaultValue = "10") size: Int
    ): ResponseEntity<Any> {
        logger.info { "retrieveAllECommerceData Begin | Sort By: $sort, Page: $page, Size $size" }
        val responseMap = HashMap<String, Any>()
        val eCommerceList: List<ECommerce>
        val eCommercePage: Page<ECommerce> = if(searchQuery.isNullOrEmpty()) {
            eCommerceService.getAllECommerce(sort, page, size)
        } else {
            eCommerceService.getAllECommerceByQuery(searchQuery, sort, page, size)
        }
        eCommerceList = eCommercePage.content
        responseMap["eCommerceList"] = eCommerceList
        logger.info { "retrieveAllECommerceData End" }
        return ResponseEntity(responseMap, HttpStatus.OK)
    }

}




