package org.ssen.controller

import org.ssen.service.SparkService

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, PathParam, Produces}

@Path("")
class SparkJobController {

    @Inject
    val sparkService: SparkService = SparkService()

    @GET
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    @Path("/{name}")
    def hello(@PathParam("name") name: String) : String = sparkService.getPodByName(name)



}