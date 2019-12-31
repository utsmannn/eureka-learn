package com.utsman.eurekaserver

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/server")
class ServerController {

    @RequestMapping("/start/{email}", method = [RequestMethod.POST])
    fun startService(@PathVariable("email") email: String): Responses {
        println("try start client")
        val processBuilder = ProcessBuilder()
        processBuilder.command("java", "-jar", "eureka-client-1-0.1.jar", "--spring.application.name=$email")
        processBuilder.start()

        return Responses("starting client user", true)
    }
}

data class Responses(val msg: String, val status: Any)
