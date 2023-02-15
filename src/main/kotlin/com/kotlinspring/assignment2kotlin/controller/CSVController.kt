package com.kotlinspring.assignment2kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("/uploads")
class CSVController {

    @GetMapping("/{name}")
    fun retrieveData(@PathVariable("name") name: String): String{
        return "Hello $name"
    }
}