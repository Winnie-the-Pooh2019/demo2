package com.example.demo.controllers

import com.example.demo.dao.PersonDao
import com.example.demo.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class PersonMvcController(
    @Autowired
    private val peopleService: PersonDao
) {
    @GetMapping("load/{page}")
    fun getPaged(@PathVariable page: Int): Person.Page {
        return peopleService.getPage(page, 10)
    }
}