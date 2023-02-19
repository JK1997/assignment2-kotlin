package com.kotlinspring.assignment2kotlin
import com.kotlinspring.assignment2kotlin.controller.ECommerceController
import com.kotlinspring.assignment2kotlin.service.ECommerceService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class ECommerceControllerUnitTest {

    @Mock
    private lateinit var eCommerceService: ECommerceService

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(ECommerceController(eCommerceService)).build()
    }

    @Test
    fun `test file upload`() {
        val file = MockMultipartFile("file", "test.csv", "text/csv", "test,data\n1,2\n3,4".toByteArray())
        mockMvc.perform(multipart("/uploads")
            .file(file))
            .andExpect(status().isOk())
    }
}
