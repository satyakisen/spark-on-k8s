package org.ssen.controller

import org.ssen.service.SparkService

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}


@Path("/hello")
class SparkJobController {

    @Inject
    val sparkService = SparkService()

    @GET
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def hello() = sparkService.getPodByName("Hello")


}