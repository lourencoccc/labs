#!/bin/sh
HADOOP_HOME=/home/hbcs/hadoop/hadoop-2.5.1
sshpass -p "hbcs2000" ssh hbcs@192.168.1.111 "$HADOOP_HOME/sbin/stop-yarn.sh"
sshpass -p "hbcs2000" ssh hbcs@192.168.1.111 "$HADOOP_HOME/sbin/stop-dfs.sh"
