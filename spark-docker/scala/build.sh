#!/bin/zsh

set -ex
VERSION=$1

WORKDIR=/Users/satyakisen/Documents/POC/spark-2.4.4-bin-hadoop2.7/
docker build -t spark:2.4.4-"$VERSION" -f scala/Dockerfile $WORKDIR
docker tag spark:2.4.4-"$VERSION" sensatyaki7/spark:2.4.4-"$VERSION"
docker push sensatyaki7/spark:2.4.4-"$VERSION"
