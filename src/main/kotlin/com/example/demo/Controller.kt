package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Controller(@Value("\${iets.met.punten}") val hello: String) {
    @Autowired
    private val environment: Environment? = null

    @GetMapping("/")
    fun blog(model: Model): String {
        return hello
    }
}
