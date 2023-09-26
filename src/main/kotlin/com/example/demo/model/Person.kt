package com.example.demo.model

import java.util.UUID

data class Person(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val phone: String
) {
    data class Page(
        val content: List<Person>,
        val page: Int,
        val pageSize: Int
    )
}
