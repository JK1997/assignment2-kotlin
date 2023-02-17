package com.kotlinspring.assignment2kotlin.service

import com.kotlinspring.assignment2kotlin.model.ECommerce
import com.kotlinspring.assignment2kotlin.repository.ECommerceRepository
import com.kotlinspring.assignment2kotlin.util.CSVUtil
import mu.KLogging
import org.apache.commons.csv.CSVFormat
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class ECommerceService(val eCommerceRepository: ECommerceRepository, val csvUtil: CSVUtil) {

    companion object : KLogging()

    var dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy H:mm")

    fun getECommerceListFromCsv(inputStream: InputStream): List<ECommerce> =
            CSVFormat.Builder.create(CSVFormat.EXCEL).apply {
                setIgnoreSurroundingSpaces(true)
            }.build().parse(inputStream.reader())
                    .drop(1) // Dropping the header
                    .map {
                        ECommerce(
                                id = 0,
                                invoiceNo = it[0],
                                stockCode = it[1],
                                description = it[2],
                                quantity = (it[3]).toInt(),
                                invoiceDate = LocalDate.parse((it[4]), dateFormatter),
                                unitPrice =  it[5].toBigDecimal(),
                                customerId = (it[6]).toIntOrNull(),
                                country = (it[7])
                        )
                    }

    fun saveECommerceList(inputStream: InputStream, file: MultipartFile){
        logger.info("saveECommerceList Start")
        if (csvUtil.hasCSVFormat(file)){
            val eCommerceList = getECommerceListFromCsv(inputStream)
            eCommerceRepository.saveAll(eCommerceList)
        }
        logger.info("saveECommerceList End")
    }

    fun getAllECommerce(
        sort: String,
        page: Int,
        size: Int
    ): Page<ECommerce> {
        val direction = if (sort.startsWith("-")) Sort.Direction.DESC else Sort.Direction.ASC
        val sortField = sort.substring(1)
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(direction, sortField))
        return eCommerceRepository.findAll(pageable)
    }
}