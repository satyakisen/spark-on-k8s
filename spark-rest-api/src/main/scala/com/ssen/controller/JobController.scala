package com.ssen.controller

import com.ssen.service.JobService

import javax.inject.Inject
import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs._

@Path("/")
class JobController{

    @Inject
    var service: JobService = _

    @GET
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    @Path("{namespace}/{name}")
    def getJobByName(@PathParam("namespace") namespace: String, @PathParam("name") name: String) : java.util.Map[String, AnyRef] = {
        service.getJobDetailsByName(namespace, name)
    }

    @POST
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    @Consumes(Array[String](MediaType.APPLICATION_JSON))
    @Path("submit/{namespace}")
    def submitJob(@PathParam("namespace") namespace: String, crdJson: java.util.Map[String, AnyRef]): java.util.Map[String, AnyRef] = {
        service.submitJob(namespace, crdJson)
    }

    @DELETE
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    @Path("delete/{namespace}/{name}")
    def deleteJob(@PathParam("namespace") namespace: String, @PathParam("name") name: String): Response = {
        Response.accepted(service.deleteJob(namespace, name)).build()
    }


}