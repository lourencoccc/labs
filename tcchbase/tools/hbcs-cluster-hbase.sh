#!/bin/sh
HBASE_VERSION=1.2.6
HBASE_TARGZ=$PRJROOT/sysapps/hbase-$HBASE_VERSION-bin.tar.gz
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113"
for host in $HOSTS
do
  echo "HBCS-HBASE Install HBase in $host"
  sshpass -p "hbcs2000" ssh hbcs@$host "rm -fr \$HOME/hbase"
  sshpass -p "hbcs2000" ssh hbcs@$host "mkdir -p \$HOME/hbase"
  sshpass -p "hbcs2000" scp $HBASE_TARGZ hbcs@$host:/home/hbcs/hbase
  sshpass -p "hbcs2000" scp $PRJROOT/sysapps/hbase-cluster-install.sh hbcs@$host:/home/hbcs/hbase
  sshpass -p "hbcs2000" ssh hbcs@$host "sh \$HOME/hbase/hbase-cluster-install.sh"
done
