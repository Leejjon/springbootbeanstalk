package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Controller @Autowired constructor(@Value("\${iets.met.punten}") val hello: String, val environment: ConfigurableEnvironment) {
    @GetMapping("/")
    fun blog(model: Model): String {
        environment.propertySources
                .forEach {
                    println("Source: " + it.source)
                    println("Iets met punten: " + it.getProperty("iets.met.punten"))
                }
        return hello
    }
}
