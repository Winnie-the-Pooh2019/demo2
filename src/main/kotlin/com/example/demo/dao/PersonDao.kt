package com.example.demo.dao

import com.example.demo.model.Person
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PersonDao {
    private val people = mutableListOf(
        Person(name = "ivan", phone = "899789798"),
        Person(name = "ne ivan", phone ="899789798"),
        Person(name = "esho ne ivan", phone = "899789798"),
        Person(name = "oleg", phone = "899789798"),
        Person(name = "ne oleg", phone = "899789798"),
        Person(name = "hz kto", phone = "899789798"),
        Person(name = "alesha", phone = "899789798"),
        Person(name = "ivan", phone = "899789798"),
        Person(name = "ne ivan", phone ="899789798"),
        Person(name = "esho ne ivan", phone = "899789798"),
        Person(name = "oleg", phone = "899789798"),
        Person(name = "ne oleg", phone = "899789798"),
        Person(name = "hz kto", phone = "899789798"),
        Person(name = "alesha", phone = "899789798"),
        Person(name = "ivan", phone = "899789798"),
        Person(name = "ne ivan", phone ="899789798"),
        Person(name = "esho ne ivan", phone = "899789798"),
        Person(name = "oleg", phone = "899789798"),
        Person(name = "ne oleg", phone = "899789798"),
        Person(name = "hz kto", phone = "899789798"),
        Person(name = "alesha", phone = "899789798"),
        Person(name = "ivan", phone = "899789798"),
        Person(name = "ne ivan", phone ="899789798"),
        Person(name = "esho ne ivan", phone = "899789798"),
        Person(name = "oleg", phone = "899789798"),
        Person(name = "ne oleg", phone = "899789798"),
        Person(name = "hz kto", phone = "899789798"),
        Person(name = "alesha", phone = "899789798"),
    )

    fun findAll(): List<Person> = people.toList()

    fun save(person: Person): Person {
        people.add(person)
        return person
    }

    fun findPersonById(id: UUID) = people.find { it.id == id }

    fun delete(person: Person) {
        people.remove(person)
    }

    fun getPage(page: Int, pageSize: Int): Person.Page {
        val _people = people.filterIndexed { index, _ ->
            index >= (page - 2) * pageSize && index < (page - 1) * pageSize
        }

        return Person.Page(_people, page, _people.size)
    }
}