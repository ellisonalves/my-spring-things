package io.ellisonalves.disablehttptrace

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(TraceMethodInterceptor()).addPathPatterns("/**")
    }

    private class TraceMethodInterceptor : HandlerInterceptor {
        override fun preHandle(
            request: HttpServletRequest,
            response: HttpServletResponse,
            handler: Any,
        ): Boolean {
            if (HttpMethod.TRACE.matches(request.method)) {
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED)
                return false
            }
            return true
        }
    }
}