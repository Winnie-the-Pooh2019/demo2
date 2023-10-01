package com.example.demo.controller

import com.example.demo.dao.CustomerRepository
import com.example.demo.model.Customer
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Profile
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.jdbc.Sql
import org.testcontainers.containers.PostgreSQLContainer

@Sql("classpath:schema.sql")
@Profile("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest(
    @LocalServerPort
    val port: Int,
    @Autowired
    private val customerRepository: CustomerRepository
) {

    @BeforeEach
    fun setUp() {
        RestAssured.baseURI = "http://localhost:$port"
        customerRepository.deleteAll()
    }

    @Test
    fun shouldGetAllCustomers() {
        val customers = listOf(
            Customer(
                name = "John",
                email = "john@localhost.com"
            ),
            Customer(
                name = "Jane",
                email = "jane@localhost.com"
            )
        )

        customerRepository.saveAll(customers)
        println("SYSTEM PORT IS $port")
        given()
            .contentType(ContentType.JSON)
            .`when`()["/customers"]
            .then()
            .statusCode(200)
    }

    companion object {

        private val postgres = PostgreSQLContainer("postgres:15")

        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            postgres.start()
        }

        @JvmStatic
        @AfterAll
        fun afterAll(): Unit {
            postgres.stop()
        }

        @JvmStatic
        @DynamicPropertySource
        fun postgresProperties(properties: DynamicPropertyRegistry) {
            properties.add("spring.datasource.url", postgres::getJdbcUrl)
            properties.add("spring.datasource.username", postgres::getUsername)
            properties.add("spring.datasource.password", postgres::getPassword)
        }
    }
}