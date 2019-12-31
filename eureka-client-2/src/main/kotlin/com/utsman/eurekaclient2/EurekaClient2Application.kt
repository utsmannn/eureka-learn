package com.utsman.eurekaclient2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableEurekaClient
class EurekaClient2Application

fun main(args: Array<String>) {
	runApplication<EurekaClient2Application>(*args)
}

@RestController
@RequestMapping("/api")
class Controller {

	@RequestMapping(value = ["/test-2"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
	fun printTest(): Responses {
		return Responses("ok", "oke-2")
	}
}

data class Responses(val msg: String,
					 val data: String)
