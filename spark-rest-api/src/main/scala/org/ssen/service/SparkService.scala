package org.ssen.service

import io.quarkus.runtime.annotations.RegisterForReflection

import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named


@Named
@ApplicationScoped
case class SparkService() {

  @PostConstruct
  val world = "World"

  def getPodByName(name: String) : String = name + " " + world;
}
