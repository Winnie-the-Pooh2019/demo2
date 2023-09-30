package com.example.demo.controllers

import com.example.demo.dao.CustomerRepository
import com.example.demo.model.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    @Autowired
    private val customerRepository: CustomerRepository
) {
    @GetMapping("/customers")
    fun getAllCustomers(): List<Customer> = customerRepository.findAll()
}