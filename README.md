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
   * [Apache Spark](https://archive.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz)

<a name="spark-docker"></a>
## Spark Docker
The spark docker directory consists of Apache Spark Scala and Python base images through which
one can submit the spark applications into kubernetes. We will be using the [Spark
kubernetes operator](https://github.com/GoogleCloudPlatform/spark-on-k8s-operator) for the demo. <br>

The scala base image can be built using the following command:
```bash
./scala/build.sh <DOCKER_IMAGE_VERSION> <SPARK_ROOT_DIR>
```
Once the image is built, it can be tagged and pushed to respective docker repository.

The python base image is in progress

<a name="spark-k8s-ops"></a>
## Spark K8S Operator
> WORK IN PROGRESS

<a name="spark-rest-api"></a>
## Spark REST API
> WORK IN PROGRESS
