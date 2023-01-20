package io.ellisonalves.disablehttptrace

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpMethod.TRACE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [GreetingsController::class])
internal class GreetingsControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @Test
    fun `should not allow trace calls`() {
        val header = "X-USER-ID"
        mockMvc.perform(
            request(TRACE, "/greetings")
                .header(header, "some_id")
        )
            .andExpect(status().isMethodNotAllowed)
            .andExpect(header().doesNotExist(header))
    }

    @Test
    fun `should allow get calls`() {
        mockMvc.perform(get("/greetings"))
            .andExpect(content().string("Hello!"))
    }

}