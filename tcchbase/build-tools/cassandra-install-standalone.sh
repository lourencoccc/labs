#!/bin/sh
cs_version=3.11
wget http://ftp.unicamp.br/pub/apache/cassandra/$cs_version/apache-cassandra-$cs_version-bin.tar.gz
mkdir -p $HOME/cassandra
mv apache-cassandra-$cs_version-bin.tar.gz $HOME/cassandra
tar -zxf $HOME/cassandra/apache-cassandra-$cs_version-bin.tar.gz -C $HOME/cassandra/
