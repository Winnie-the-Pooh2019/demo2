package com.example.demo.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "customers")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID? = null,

    @Column(nullable = false)
    private val name: String? = null,

    @Column(nullable = false, unique = true)
    private val email: String? = null,
) {
    constructor() : this(null, null, null)
}
