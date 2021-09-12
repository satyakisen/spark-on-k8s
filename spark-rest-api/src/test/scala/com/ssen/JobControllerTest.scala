package com.ssen

import com.ssen.service.JobService
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.mockito.Mockito

import scala.collection.JavaConverters.mapAsJavaMapConverter
import scala.collection.mutable

@QuarkusTest
class JobControllerTest {

    @InjectMock
    var service : JobService = _


    @Test
    def testHelloEndpoint(): Unit = {
        val response = mutable.Map("namespace" -> "default".asInstanceOf[AnyRef], "name" -> "spark-pi".asInstanceOf[AnyRef]).asJava

        Mockito.when(service.getJobDetailsByName("default", "spark-pi")).thenReturn(response)

        given().`when`().get("/api/v1/default/spark-pi").`then`()
             .statusCode(200)
          .body("namespace", equalTo("default"))
          .body("name", equalTo("spark-pi"))
    }

}