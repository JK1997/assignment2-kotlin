package com.kotlinspring.assignment2kotlin.util

import com.kotlinspring.assignment2kotlin.exception.CSVFileTypeException
import com.kotlinspring.assignment2kotlin.model.ECommerce
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.math.BigDecimal
import java.math.RoundingMode
import java.nio.charset.StandardCharsets
import java.util.function.Consumer

@Service
class CSVUtil {

    fun hasCSVFormat(file: MultipartFile): Boolean {
        if (file.isEmpty) {
            throw CSVFileTypeException("File is empty")
        } else if (null == file.contentType) {
            throw CSVFileTypeException("Content type is empty")
        } else if (!(file.contentType.equals("text/csv", ignoreCase = true) || file.contentType.equals("application/vnd.ms-excel", ignoreCase = true) || file.contentType.equals("multipart/form-data", ignoreCase = true))) {
            throw CSVFileTypeException("Unaccepted media type. Only csv files are accepted")
        }
        return true
    }
}
