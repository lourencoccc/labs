#!/bin/sh
HADOOP_VERSION=2.5.1
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113 192.168.1.114"
for host in $HOSTS
do
  # sshpass -p "hbcs2000" ssh hbcs@$host "rm -fr \$HOME/hadoop"
  sshpass -p "hbcs2000" ssh hbcs@$host "mkdir -p \$HOME/hadoop"
  sshpass -p "hbcs2000" scp $PRJROOT/sysapps/hadoop-$HADOOP_VERSION.tar.gz hbcs@$host:/home/hbcs/hadoop
  sshpass -p "hbcs2000" scp $PRJROOT/sysapps/hadoop-$HADOOP_VERSION-src.tar.gz hbcs@$host:/home/hbcs/hadoop
  sshpass -p "hbcs2000" scp $PRJROOT/sysapps/hadoop-cluster-install.sh hbcs@$host:/home/hbcs/hadoop
  sshpass -p "hbcs2000" ssh hbcs@$host "sh \$HOME/hadoop/hadoop-cluster-install.sh"
done
