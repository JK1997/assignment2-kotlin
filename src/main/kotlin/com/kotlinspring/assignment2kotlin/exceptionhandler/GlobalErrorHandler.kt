package com.kotlinspring.assignment2kotlin.exceptionhandler

import com.kotlinspring.assignment2kotlin.exception.CSVFileTypeException
import mu.KLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    companion object : KLogging()

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        logger.error("MethodArgumentNotValidException observed : ${ex.message}", ex)
        val errors = ex.bindingResult.allErrors
            .map { error -> error.defaultMessage!! }
            .sorted()

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                errors.joinToString(", ") { it }
            )
    }

    @ExceptionHandler(CSVFileTypeException::class)
    fun handleCSVFileTypeError(ex: CSVFileTypeException, request: WebRequest): ResponseEntity<Any> {
        logger.info("Exception occurred: ${ex.message} on request: $request")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ex.message
            )
    }

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: java.lang.Exception, request: WebRequest): ResponseEntity<Any> {
        logger.info("Exception occurred: ${ex.message} on request: $request", ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ex.message
            )
    }
}