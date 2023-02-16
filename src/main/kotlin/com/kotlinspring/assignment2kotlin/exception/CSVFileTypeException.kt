package com.kotlinspring.assignment2kotlin.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class CSVFileTypeException (message: String) : RuntimeException(message)