package com.kotlinspring.assignment2kotlin.controller

import com.kotlinspring.assignment2kotlin.service.ECommerceService
import mu.KLogging
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class ECommerceController(val eCommerceService: ECommerceService) {
    companion object : KLogging()
    @PostMapping(path = ["/uploads"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun postEcommerceData(@RequestParam("file") file: MultipartFile) {
        logger.info("postEcommerceData Start | file type: ${file.contentType}")
        //use - Executes the given block function on this resource and then closes it down correctly whether an exception is thrown or not.
        file.inputStream.use {
            eCommerceService.saveECommerceList(it, file)
        }
        logger.info("postEcommerceData End | file type: ${file.contentType}")
    }
}

