package io.ellisonalves.disablehttptrace

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(method = [RequestMethod.TRACE])
class GreetingsController {

    @GetMapping(
        "/greetings",
        produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    fun hello(): String = "Hello!"
}