package io.ellisonalves.disablehttptrace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DisableHttpTraceApplication

fun main(args: Array<String>) {
	runApplication<DisableHttpTraceApplication>(*args)
}
