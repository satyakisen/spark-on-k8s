package org.ssen

import javax.ws.rs.{GET, Path, Produces}
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @GET
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def hello() = "Hello RESTEasy"
}