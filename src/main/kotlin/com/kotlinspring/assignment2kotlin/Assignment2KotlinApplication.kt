package com.kotlinspring.assignment2kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.kotlinspring.assignment2kotlin.service")
@ComponentScan("com.kotlinspring.assignment2kotlin.repository")
@ComponentScan("com.kotlinspring.assignment2kotlin.util")
class Assignment2KotlinApplication

fun main(args: Array<String>) {
    runApplication<Assignment2KotlinApplication>(*args)
}
