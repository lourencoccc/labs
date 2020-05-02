#!/bin/sh
label=teste0
COMANDS="query1Normal query2Normal query3Normal query4Normal"
ATTEMPTS="1 2 3"
for queryName in $COMANDS
do
  hadoop-cluster-start.sh
  sleep 60
  hbase-cluster-start.sh
  sleep 60
  for attempt in $ATTEMPTS
  do
      echo  "$queryName $label $attempt "
      hbcs-hbase $queryName cluster $label $attempt
      sleep 5
  done
  hbase-cluster-stop.sh
  sleep 60
  hadoop-cluster-stop.sh
done
