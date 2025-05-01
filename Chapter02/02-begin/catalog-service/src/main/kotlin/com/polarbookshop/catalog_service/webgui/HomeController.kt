package com.polarbookshop.catalog_service.webgui

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun getGreeting(): String {
        return "Polar Bookshop 도서 카탈로그에 오신 것을 환영합니다!"
    }

    @GetMapping("/health")
    fun getHealth(): String {
        return "OK"
    }

    @GetMapping("/info")
    fun getInfo(): String {
        return "Polar Bookshop Catalog Service v1.0"
    }



    @GetMapping("/error")
    fun getError(): String {
        return "An error occurred"
    }

    @GetMapping("/error/404")
    fun getError404(): String {
        throw RuntimeException("Not Found")
    }

    @GetMapping("/error/400")
    fun getError400(): String {
        throw RuntimeException("Bad Request")
    }

    @GetMapping("/error/401")
    fun getError401(): String {
        throw RuntimeException("Unauthorized")
    }

    @GetMapping("/error/403")
    fun getError403(): String {
        throw RuntimeException("Forbidden")
    }

    @GetMapping("/error/409")
    fun getError409(): String {
        throw RuntimeException("Conflict")
    }

    @GetMapping("/error/500")
    fun getError500(): String {
        throw RuntimeException("Internal Server Error")
    }

    @GetMapping("/error/502")
    fun getError502(): String {
        throw RuntimeException("Bad Gateway")
    }

    @GetMapping("/error/503")
    fun getError503(): String {
        throw RuntimeException("Service Unavailable")
    }

    @GetMapping("/error/504")
    fun getError504(): String {
        throw RuntimeException("Gateway Timeout")
    }
}