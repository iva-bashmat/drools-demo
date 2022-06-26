package com.example.drools

import com.example.drools.model.Route
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DroolsApplication

fun main(args: Array<String>) {
	runApplication<DroolsApplication>(*args)
}
