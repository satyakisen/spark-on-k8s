package com.ssen.service

import io.fabric8.kubernetes.client.DefaultKubernetesClient
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext

import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class JobService {
  private[this] var client : DefaultKubernetesClient = _


  private[this] var crdContext: CustomResourceDefinitionContext = _
  @PostConstruct
  def init():Unit  = {
    client = new DefaultKubernetesClient()

    crdContext = new CustomResourceDefinitionContext.Builder()
      .withName("sparkapplications.sparkoperator.k8s.io")
      .withGroup("sparkoperator.k8s.io")
      .withScope("Namespaced")
      .withPlural("sparkapplications")
      .withVersion("v1beta2")
      .withKind("SparkApplication")
      .build()
  }

  def getJobDetailsByName(namespace: String, name: String): java.util.Map[String, AnyRef] = {
    client.customResource(crdContext).inNamespace(namespace).withName(name).get()
  }

  def submitJob(namespace: String, crdJson: java.util.Map[String, AnyRef]): java.util.Map[String, AnyRef] = {
    client.customResource(crdContext).inNamespace(namespace).create(crdJson)
  }


  def deleteJob(namespace: String, name: String): Boolean = client.customResource(crdContext).inNamespace(namespace).withName(name).delete()
}
