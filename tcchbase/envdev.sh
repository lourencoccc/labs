#!/bin/sh
#Project
export PROJECT=hbcs-comparison
export PRJROOT=`pwd`
export PRJCONFIG=$PRJROOT/etc
export PRJDATASET=$PRJROOT/var/hbcs-dataset
export PRJDATASET_DEV=$PRJROOT/var/hbcs-dataset-dev

#Databases
export HBASE_HOME=$HOME/hbase/hbase-2.1.0 
export CASSANDRA_HOME=$HOME/cassandra/apache-cassandra-3.11.3

#Hadoop
export HADOOP_PREFIX=$HOME/hadoop/hadoop-2.8.4
export HADOOP_HOME=$HADOOP_PREFIX
export HADOOP_COMMON_HOME=$HADOOP_PREFIX
export HADOOP_CONF_DIR=$HADOOP_PREFIX/etc/hadoop
export HADOOP_HDFS_HOME=$HADOOP_PREFIX
export HADOOP_MAPRED_HOME=$HADOOP_PREFIX
export HADOOP_YARN_HOME=$HADOOP_PREFIX

#bin
export PATH=$PATH:$HBASE_HOME/bin
export PATH=$PATH:$CASSANDRA_HOME/bin
export PATH=$PATH:$HADOOP_HOME/bin
export PATH=$PATH:$HADOOP_HOME/sbin
export PATH=$PATH:$PRJROOT/tools
export PATH=$PATH:$PRJROOT/apps/hbcs-comparison/resources/scripts/sbin
export PATH=$PATH:$PRJROOT/apps/hbcs-comparison/hbcs-hbase/build/install/hbcs-hbase/bin
export PATH=$PATH:$PRJROOT/apps/hbcs-comparison/hbcs-cassandra/build/install/hbcs-cassandra/bin
