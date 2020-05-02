#!/bin/sh
#cassandra
CASSANDRA_VERSION=3.10
CASSANDRA_LOCAL=$HOME/cassandra
CASSANDRA_DATA=$CASSANDRA_LOCAL/data
CASSANDRA_HOME=$CASSANDRA_LOCAL/apache-cassandra-$CASSANDRA_VERSION
CASSANDRA_TARGZ=apache-cassandra-$CASSANDRA_VERSION-bin.tar.gz
DOWNLOAD_DIR=$CASSANDRA_LOCAL
IP_ADDR=`ip route get 1 | awk '{print $NF;exit}'`
APACHE_REPO=http://archive.apache.org/dist

if [ ! -f "$DOWNLOAD_DIR/$CASSANDRA_TARGZ" ]; then
  echo "Donwload Cassnadra from $APACHE_REPO/cassandra/$CASSANDRA_VERSION/$CASSANDRA_TARGZ"
  wget $APACHE_REPO/cassandra/$CASSANDRA_VERSION/$CASSANDRA_TARGZ -O $DOWNLOAD_DIR/$CASSANDRA_TARGZ
fi
IP_ADDR=`ip route get 1 | awk '{print $NF;exit}'`
if [ -d "$CASSANDRA_HOME" ]; then
  echo "Casandra is installed $CASSANDRA_HOME"
else
  echo "HBCS-CASSANDRA Install Casandra $CASSANDRA_LOCAL"
  mkdir -p $HOME/cassandra
  tar -zxf $DOWNLOAD_DIR/$CASSANDRA_TARGZ -C $CASSANDRA_LOCAL

  echo "HBCS-CASSANDRA Configure $CASSANDRA_HOME/conf/cassandra.yml"
  sed -i -e "s/^cluster_name:.*/cluster_name: 'HbcsCluster'/g" $CASSANDRA_HOME/conf/cassandra.yaml
  sed -i -e "s/^listen_address:.*/listen_address: $IP_ADDR/g" $CASSANDRA_HOME/conf/cassandra.yaml
  sed -i -e "s/^          - seeds:.*/          - seeds: \"192.168.1.111,192.168.1.112,192.168.1.113\"/g" $CASSANDRA_HOME/conf/cassandra.yaml
  sed -i -e "s/^endpoint_snitch:.*/endpoint_snitch: GossipingPropertyFileSnitch/g" $CASSANDRA_HOME/conf/cassandra.yaml
  echo "HBCS-CASSANDRA Configure $CASSANDRA_HOME/bin/stop-server"
  sed -i -e "s/\# user=/user=/" $CASSANDRA_HOME/bin/stop-server
  sed -i -e "s/\# pgrep/pgrep/" $CASSANDRA_HOME/bin/stop-server
fi
