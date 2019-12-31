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
        val pathClient1 = "../../eureka-client-1/build/libs"
        val jarCommand = "java -jar build/libs/eureka-client-1-0.1.jar --spring.application.instance_id=woy"
        /*val permission = "chmod u+x /eureka-client-1-0.1.jar"
        val permissionCommand = ProcessBuilder(permission)
        permissionCommand.start()*/
        val pb = ProcessBuilder("java -jar eureka-client-1-0.1.jar --spring.application.instance_id=$email")
        //val pb = ProcessBuilder
        //val pb = ProcessBuilder("ls")
        val process = pb.start()

        return Responses("starting client user", process.outputStream.toString())
    }
}

data class Responses(val msg: String, val status: Any)
