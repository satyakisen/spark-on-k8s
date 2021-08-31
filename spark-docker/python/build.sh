#!/bin/bash

set -ex
VERSION=$1

WORKDIR=$2
BASE_IMAGE=$3

docker build -t spark-py:2.4.4-"$VERSION" -f python/Dockerfile --build-arg base_img="$BASE_IMAGE" $WORKDIR