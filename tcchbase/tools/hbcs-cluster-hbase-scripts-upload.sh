#!/bin/sh
HBASE_VERSION=1.2.6
HBASE_HOME=/hbcs/hbase/hbase-$HBASE_VERSION
HOSTS="192.168.1.111"
for host in $HOSTS
do
  echo "HBCS-HBASE Install HBase in $host"
  sshpass -p "hbcs2000" ssh hbcs@$host "rm -fr \$HOME/hbase-scripts"
  sshpass -p "hbcs2000" ssh hbcs@$host "mkdir -p \$HOME/hbase-scripts"
  sshpass -p "hbcs2000" scp $PRJROOT/apps/scripts/hbase/* hbcs@$host:/home/hbcs/hbase-scripts
done
