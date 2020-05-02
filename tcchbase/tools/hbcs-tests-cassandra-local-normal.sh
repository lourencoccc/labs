#!/bin/sh
label=teste0
cassandra
sleep 30
COMANDS="query1Normal query2Normal query3Normal query4Normal"
ATTEMPTS="1 2 3"
for queryName in $COMANDS
do
  for attempt in $ATTEMPTS
  do
      echo  "$queryName $label $attempt "
      hbcs-cassandra $queryName local $label $attempt
      sleep 5
  done
done
stop-server
