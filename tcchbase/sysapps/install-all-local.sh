#!/bin/sh

if [[ -z $PRJROOT ]]; then
  echo "PRJROOT  is empty, please execute source envdev.sh"
  echo "Abort..."
  exit 1
fi

#hadoop
HADOOP_VERSION=2.5.1
HADOOP_LOCAL=$HOME/hadoop
HADOOP_TARGZ=hadoop-$HADOOP_VERSION.tar.gz
HADOOP_SRC_TARGZ=hadoop-$HADOOP_VERSION-src.tar.gz
HADOOP_HOME=$HADOOP_LOCAL/hadoop-$HADOOP_VERSION
HADOOP_PREFIX=$HADOOP_LOCAL/hadoop-$HADOOP_VERSION
HADOOP_HOME=$HADOOP_PREFIX
HADOOP_COMMON_HOME=$HADOOP_PREFIX
HADOOP_CONF_DIR=$HADOOP_PREFIX/etc/hadoop
HADOOP_HDFS_HOME=$HADOOP_PREFIX
HADOOP_MAPRED_HOME=$HADOOP_PREFIX
HADOOP_YARN_HOME=$HADOOP_PREFIX

#hbase
HBASE_VERSION=1.2.6
HBASE_LOCAL=$HOME/hbase
HBASE_ROOTDIR=$HBASE_LOCAL/rootdir
HBASE_ZOOKEEPER=$HBASE_LOCAL/zookeeper
HBASE_TARGZ=hbase-$HBASE_VERSION-bin.tar.gz
HBASE_HOME=$HBASE_LOCAL/hbase-$HBASE_VERSION

#cassandra
CASSANDRA_VERSION=3.11
CASSANDRA_LOCAL=$HOME/cassandra
CASSANDRA_HOME=$CASSANDRA_LOCAL/apache-cassandra-$CASSANDRA_VERSION
CASSANDRA_TARGZ=apache-cassandra-$CASSANDRA_VERSION-bin.tar.gz
DOWNLOAD_DIR=$PRJROOT/sysapps

#java
JAVA_TARGZ=jdk-8u131-linux-x64.tar.gz
JAVA_REPO=http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/$JAVA_TARGZ

APACHE_REPO=http://archive.apache.org/dist

if [ ! -f "$DOWNLOAD_DIR/$HADOOP_TARGZ" ]; then
  echo "Donwload Hadoop from $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_TARGZ"
  wget $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_TARGZ -O $DOWNLOAD_DIR/$HADOOP_TARGZ
fi

if [ ! -f "$DOWNLOAD_DIR/$HADOOP_SRC_TARGZ" ]; then
  echo "Donwload Hadoop source from $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_SRC_TARGZ"
  wget $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_SRC_TARGZ -O $DOWNLOAD_DIR/$HADOOP_SRC_TARGZ
fi

if [ ! -f "$DOWNLOAD_DIR/$HBASE_TARGZ" ]; then
  echo "Donwload HBase from $APACHE_REPO/hbase/$HBASE_VERSION/$HBASE_TARGZ"
  wget $APACHE_REPO/hbase/$HBASE_VERSION/$HBASE_TARGZ -O $DOWNLOAD_DIR/$HBASE_TARGZ
fi

if [ ! -f "$DOWNLOAD_DIR/$CASSANDRA_TARGZ" ]; then
  echo "Donwload Cassnadra from $APACHE_REPO/cassandra/$CASSANDRA_VERSION/$CASSANDRA_TARGZ"
  wget $APACHE_REPO/cassandra/$CASSANDRA_VERSION/$CASSANDRA_TARGZ -O $DOWNLOAD_DIR/$CASSANDRA_TARGZ
fi

if [ ! -f "$DOWNLOAD_DIR/$JAVA_TARGZ" ]; then
  echo "Donwload Java from $JAVA_REPO"
  wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" $JAVA_REPO -O $DOWNLOAD_DIR/$JAVA_TARGZ
fi

if [ -d "$HBASE_HOME" ]; then
  echo "HBase is installed $HBASE_HOME"
else
  echo "Install Hbase standalone"
  mkdir -p $HBASE_ROOTDIR
  mkdir -p $HBASE_ZOOKEEPER
  tar -zxf $DOWNLOAD_DIR/$HBASE_TARGZ-C $HOME/hbase/
  #hbase standalone mode
  echo "<?xml version=\"1.0\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <configuration>
    <property>
      <name>hbase.rootdir</name>
      <value>file://$HBASE_ROOTDIR</value>
    </property>
    <property>
      <name>hbase.zookeeper.property.dataDir</name>
      <value>$HBASE_ZOOKEEPER</value>
    </property>
  </configuration>" > $HBASE_LOCAL/hbase-$HBASE_VERSION/conf/hbase-site.xml
fi

if [ -d "$CASSANDRA_HOME" ]; then
  echo "Casandra is installed $CASSANDRA_HOME"
else
  echo "Install Casandra $CASSANDRA_LOCAL"
  mkdir -p $HOME/cassandra
  tar -zxf $DOWNLOAD_DIR/$CASSANDRA_TARGZ -C $HOME/cassandra/
fi

if [ -d "$HADOOP_HOME" ]; then
  echo "Hadoop is installed $HADOOP_HOME"
else
  echo "Install Hadoop $HADOOP_LOCAL"
  mkdir -p $HADOOP_LOCAL

  tar -zxf $DOWNLOAD_DIR/$HADOOP_SRC_TARGZ -C $HADOOP_LOCAL
  tar -zxf $DOWNLOAD_DIR/$HADOOP_SRC_TARGZ -C $HADOOP_LOCAL

  echo "Configuring HDFS $HADOOP_CONF_DIR/hdfs-site.xml"
  echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <configuration>
      <property>
          <name>dfs.datanode.data.dir</name>
          <value>file://$HADOOP_LOCAL/hadoop-$HADOOP_VERSION/hdfs/datanode</value>
          <description>Comma separated list of paths on the local filesystem of a DataNode where it should store its blocks.</description>
      </property>

      <property>
          <name>dfs.namenode.name.dir</name>
          <value>file://$HADOOP_LOCAL/hadoop-$HADOOP_VERSION/hdfs/namenode</value>
          <description>Path on the local filesystem where the NameNode stores the namespace and transaction logs persistently.</description>
      </property>
  </configuration>" > $HADOOP_CONF_DIR/hdfs-site.xml

  echo "Configuring HDFS $HADOOP_CONF_DIR/core-site.xml"
  echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <configuration>
      <property>
          <name>fs.defaultFS</name>
          <value>hdfs://localhost/</value>
          <description>NameNode URI</description>
      </property>
  </configuration>" > $HADOOP_CONF_DIR/core-site.xml

  echo "Configuring YARN $HADOOP_CONF_DIR/yarn-site.xml"
  echo "<?xml version=\"1.0\"?>
  <configuration>
      <property>
          <name>yarn.scheduler.minimum-allocation-mb</name>
          <value>128</value>
          <description>Minimum limit of memory to allocate to each container request at the Resource Manager.</description>
      </property>
      <property>
          <name>yarn.scheduler.maximum-allocation-mb</name>
          <value>2048</value>
          <description>Maximum limit of memory to allocate to each container request at the Resource Manager.</description>
      </property>
      <property>
          <name>yarn.scheduler.minimum-allocation-vcores</name>
          <value>1</value>
          <description>The minimum allocation for every container request at the RM, in terms of virtual CPU cores. Requests lower than this won't take effect, and the specified value will get allocated the minimum.</description>
      </property>
      <property>
          <name>yarn.scheduler.maximum-allocation-vcores</name>
          <value>2</value>
          <description>The maximum allocation for every container request at the RM, in terms of virtual CPU cores. Requests higher than this won't take effect, and will get capped to this value.</description>
      </property>
      <property>
          <name>yarn.nodemanager.resource.memory-mb</name>
          <value>4096</value>
          <description>Physical memory, in MB, to be made available to running containers</description>
      </property>
      <property>
          <name>yarn.nodemanager.resource.cpu-vcores</name>
          <value>4</value>
          <description>Number of CPU cores that can be allocated for containers.</description>
      </property>
  </configuration>" > $HADOOP_CONF_DIR/yarn-site.xml
fi
