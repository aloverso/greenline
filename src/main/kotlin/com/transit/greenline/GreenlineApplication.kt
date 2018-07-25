package com.transit.greenline

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreenlineApplication

fun main(args: Array<String>) {
    runApplication<GreenlineApplication>(*args)
}
