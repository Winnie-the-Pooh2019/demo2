package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID? = null,

    @Column(nullable = false)
    private val name: String,

    @Column(nullable = false, unique = true)
    private val email: String
)
