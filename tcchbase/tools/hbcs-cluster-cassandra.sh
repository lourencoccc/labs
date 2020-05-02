#!/bin/sh
CASSANDRA_VERSION=3.10
CASSANDRA_TARGZ=$PRJROOT/sysapps/apache-cassandra-$CASSANDRA_VERSION-bin.tar.gz
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113 192.168.1.114"
for host in $HOSTS
do
  echo "HBCS-CASSANDRA Install Cassandra in $host"
  sshpass -p "hbcs2000" ssh hbcs@$host "rm -fr \$HOME/cassandra"
  sshpass -p "hbcs2000" ssh hbcs@$host "mkdir -p \$HOME/cassandra"
  sshpass -p "hbcs2000" scp $CASSANDRA_TARGZ hbcs@$host:/home/hbcs/cassandra
  sshpass -p "hbcs2000" scp $PRJROOT/sysapps/cassandra-cluster-install.sh hbcs@$host:/home/hbcs/cassandra
  sshpass -p "hbcs2000" ssh hbcs@$host "sh \$HOME/cassandra/cassandra-cluster-install.sh"
done
