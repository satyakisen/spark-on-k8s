# Spark on Kubernetes 

This repo demonstrates spark on kubernetes with a custom Kubernetes REST API
made from scratch. 
Apache Spark version 2.4.4 is used in this demo project. 

## Table of Contents
* [Pre-requisite](#pre-requisite)
* [Spark Docker](#spark-docker)
* [Spark K8S Operator](#spark-k8s-ops) 


<a name="pre-requisite"></a>
## Pre-requisite
1. Spark Docker
   * Docker

<a name="spark-docker"></a>
## Spark Docker
The spark docker directory consists of Apache Spark Scala and Python base images through which
one can submit the spark applications into kubernetes. We will be using the [Spark
kubernetes operator](https://github.com/GoogleCloudPlatform/spark-on-k8s-operator) for the demo. <br>

The Scala base image can be built using the following command:
```bash
docker build -t <IMAGE_NAME>:<IMAGE_VERSION> ./spark-docker/scala/
```
Once the image is built, it can be tagged and pushed to respective docker repository.

The Python base image can be built using the following command:
```bash
docker build -t <IMAGE_NAME>:<IMAGE_VERSION> --build-args base_image=<SCALA_SPARK_BASE_IMAGE> ./spark-docker/python/ 
```

The Scala Spark base image is required for building the Python Spark base image.
Once the image is built, it can be tagged and pushed to respective docker repository.

<a name="spark-k8s-ops"></a>
## Spark K8S Operator
> WORK IN PROGRESS

<a name="spark-rest-api"></a>
## Spark REST API
> WORK IN PROGRESS
