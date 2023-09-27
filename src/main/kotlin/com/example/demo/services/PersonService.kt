package com.example.demo.services

import com.example.demo.dao.PersonDao
import com.example.demo.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(
    @Autowired
    private val personRepository: PersonDao
) {
    fun findAll(): List<Person> = personRepository.findAll()

    fun findById(id: String): Person? = personRepository.findPersonById(UUID.fromString(id))

    fun save(person: Person): Person? {
        if (personRepository.findPersonById(person.id) != null)
            return null

        return personRepository.save(person)
    }

    fun delete(person: Person) = personRepository.delete(person)
}