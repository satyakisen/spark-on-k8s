#!/bin/bash

set -ex
VERSION=$1

WORKDIR=$2
docker build -t spark:2.4.4-"$VERSION" -f scala/Dockerfile "$WORKDIR"
