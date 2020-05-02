#!/bin/sh
#hbase
HBASE_VERSION=1.2.6
HBASE_LOCAL=$HOME/hbase
HBASE_ZOOKEEPER=$HBASE_LOCAL/zookeeper
HBASE_TARGZ=hbase-$HBASE_VERSION-bin.tar.gz
HBASE_HOME=$HBASE_LOCAL/hbase-$HBASE_VERSION
DOWNLOAD_DIR=$HBASE_LOCAL
APACHE_REPO=http://archive.apache.org/dist

if [ ! -f "$DOWNLOAD_DIR/$HBASE_TARGZ" ]; then
  echo "Donwload HBase from $APACHE_REPO/hbase/$HBASE_VERSION/$HBASE_TARGZ"
  wget $APACHE_REPO/hbase/$HBASE_VERSION/$HBASE_TARGZ -O $DOWNLOAD_DIR/$HBASE_TARGZ
fi

if [ -d "$HBASE_HOME" ]; then
  echo "HBase is installed $HBASE_HOME"
else
  echo "HBCS-HBASE Install HBase"

  echo "HBCS-HBASE Create dir $HBASE_ZOOKEEPER"
  mkdir -p $HBASE_ZOOKEEPER

  echo "HBCS-HBASE Extract $DOWNLOAD_DIR/$HBASE_TARGZ to $HBASE_LOCAL"
  tar -zxf $DOWNLOAD_DIR/$HBASE_TARGZ -C $HBASE_LOCAL
When to configure a cluster to set property "hbase.master" in hbase-site.xml with your hostname or IP, example:
  echo "HBCS-HBASE Configure $HBASE_HOME/conf/hbase-site.xml"
  #hbase cluster mode
  echo "<?xml version=\"1.0\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <property>
    <name>hbase.master</name>
    <value>192.168.1.111:16000</value>
  </property>
  <configuration>
    <property>
      <name>hbase.cluster.distributed</name>
      <value>true</value>
    </property>
    <property>
      <name>hbase.rootdir</name>
      <value>hdfs://192.168.1.111:8020/hbase</value>
    </property>
    <property>
      <name>hbase.rpc.timeout</name>
      <value>180000</value>
    </property>
    <property>
      <name>hbase.zookeeper.quorum</name>
      <value>192.168.1.111,192.168.1.112,192.168.1.113</value>
    </property>
    <property>
      <name>hbase.zookeeper.property.dataDir</name>
      <value>$HBASE_ZOOKEEPER</value>
    </property>
  </configuration>" > $HBASE_HOME/conf/hbase-site.xml

  echo "HBCS-HBASE Configure $HBASE_HOME/conf/regionservers"
  echo "192.168.1.112\n192.168.1.113" > $HBASE_HOME/conf/regionservers

  echo "HBCS-HBASE Configure $HBASE_HOME/conf/hbase-env.sh"
  sed -i -e "s/^\# export JAVA_HOME.*/export JAVA_HOME=\/usr\/lib\/jvm\/java-8-oracle/g" $HBASE_HOME/conf/hbase-env.sh
  sed -i -e "s/^\# export HBASE_MANAGES_ZK.*/export HBASE_MANAGES_ZK=true/g" $HBASE_HOME/conf/hbase-env.sh
fi
