#!/bin/sh
label=teste0
start-hbase.sh
sleep 15
COMANDS="query1Normal query2Normal query3Normal query4Normal"
ATTEMPTS="1 2 3"
for queryName in $COMANDS
do
  for attempt in $ATTEMPTS
  do
      echo  "$queryName $label $attempt "
      hbcs-hbase $queryName local $label $attempt
      sleep 5
  done
done
stop-hbase.sh
