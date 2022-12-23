#!/bin/sh
set -e

docker build  -t lambda-v3 .

containerId=$(docker create -ti lambda-v3 bash)
docker cp "${containerId}":/build/ lambda-v3/graalvm