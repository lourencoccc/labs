#!/bin/sh
CASSANDRA_VERSION=3.10
CASSANDRA_LOCAL=/home/hbcs/cassandra
CASSANDRA_HOME=$CASSANDRA_LOCAL/apache-cassandra-$CASSANDRA_VERSION
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113 192.168.1.114"
for host in $HOSTS
do
  echo "HBCS-CASSANDRA Start Cassandra in $host"
  sshpass -p "hbcs2000" ssh hbcs@$host "$CASSANDRA_HOME/bin/cassandra"
  echo "HBCS-CASSANDRA Wait 5s"
  sleep 5
done
