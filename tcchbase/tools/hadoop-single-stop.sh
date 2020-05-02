#!/bin/sh
## Stop HDFS daemons
# Stop the namenode daemon
$HADOOP_PREFIX/sbin/hadoop-daemon.sh stop namenode
# Stop the datanode daemon
$HADOOP_PREFIX/sbin/hadoop-daemon.sh stop datanode

## Stop YARN daemons
# Stop the resourcemanager daemon
$HADOOP_PREFIX/sbin/yarn-daemon.sh stop resourcemanager
# Stop the nodemanager daemon
$HADOOP_PREFIX/sbin/yarn-daemon.sh stop nodemanager
