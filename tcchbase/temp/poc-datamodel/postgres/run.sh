#!/bin/bash

pgdata=$PWD/.data


if [ -d "$pgdata" ]; then
  mkdir -p $pgdata
  chown -R 5432:5432 $pgdata
fi

docker stop poc-postgres
docker rm poc-postgres

docker run -t \
  -v $pgdata:/var/lib/postgresql/data \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  --name poc-postgres poc-datamodel-postgres
