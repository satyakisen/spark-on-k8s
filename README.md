# Spark on Kubernetes 

This repo demonstrates spark on kubernetes. 
Apache Spark version 2.4.4 is used in this demo project. 
The demo is divided into multiple subsections. 
1. Spark Docker
2. Spark K8S Operator
3. Spark REST Api

## Pre-requisite
1. Spark Docker
   * [Apache Spark](https://archive.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz)

## Spark Docker
The spark docker directory consists of Apache Spark Scala and Python base images through which
one can submit the spark applications into kubernetes. We will be using the Spark
kubernetes operator for the demo. <br>

The scala base image can be built using the following command:
```bash
./scala/build.sh <DOCKER_IMAGE_VERSION> <SPARK_ROOT_DIR>
```
Once the image is built, it can be tagged and pushed to respective docker repository.

The python base image is in progress