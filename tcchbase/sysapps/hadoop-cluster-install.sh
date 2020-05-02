#!/bin/sh
IP_NAMENODE=192.168.1.111
IP_ADDR=`ip route get 1 | awk '{print $NF;exit}'`

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

DOWNLOAD_DIR=$HADOOP_LOCAL

APACHE_REPO=http://archive.apache.org/dist

if [ ! -f "$DOWNLOAD_DIR/$HADOOP_TARGZ" ]; then
  echo "Donwload Hadoop from $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_TARGZ"
  wget $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_TARGZ -O $DOWNLOAD_DIR/$HADOOP_TARGZ
fi

if [ ! -f "$DOWNLOAD_DIR/$HADOOP_SRC_TARGZ" ]; then
  echo "Donwload Hadoop source from $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_SRC_TARGZ"
  wget $APACHE_REPO/hadoop/common/hadoop-$HADOOP_VERSION/$HADOOP_SRC_TARGZ -O $DOWNLOAD_DIR/$HADOOP_SRC_TARGZ
fi

if [ -d "$HADOOP_HOME" ]; then
  echo "Hadoop is installed $HADOOP_HOME"
else

  tar -zxf $HADOOP_LOCAL/hadoop-$HADOOP_VERSION.tar.gz -C $HADOOP_LOCAL
  tar -zxf $HADOOP_LOCAL/hadoop-$HADOOP_VERSION-src.tar.gz -C $HADOOP_LOCAL

  echo "
  export HADOOP_PREFIX=$HADOOP_LOCAL/hadoop-$HADOOP_VERSION
  export HADOOP_HOME=$HADOOP_PREFIX
  export HADOOP_COMMON_HOME=$HADOOP_PREFIX
  export HADOOP_CONF_DIR=$HADOOP_PREFIX/etc/hadoop
  export HADOOP_HDFS_HOME=$HADOOP_PREFIX
  export HADOOP_MAPRED_HOME=$HADOOP_PREFIX
  export HADOOP_YARN_HOME=$HADOOP_PREFIX" >> ~/.bashrc

  echo "Configuring HDFS $HADOOP_CONF_DIR/hdfs-site.xml"
  echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <configuration>
      <property>
          <name>dfs.datanode.data.dir</name>
          <value>file://$HADOOP_LOCAL/hdfs/datanode</value>
          <description>Comma separated list of paths on the local filesystem of a DataNode where it should store its blocks.</description>
      </property>

      <property>
          <name>dfs.namenode.name.dir</name>
          <value>file://$HADOOP_LOCAL/hdfs/namenode</value>
          <description>Path on the local filesystem where the NameNode stores the namespace and transaction logs persistently.</description>
      </property>
  </configuration>" > $HADOOP_CONF_DIR/hdfs-site.xml

  echo "Configuring HDFS $HADOOP_CONF_DIR/core-site.xml"
  echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
  <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
  <configuration>
      <property>
          <name>fs.defaultFS</name>
          <value>hdfs://$IP_NAMENODE/</value>
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
      <property>
          <name>yarn.resourcemanager.hostname</name>
          <value>$IP_NAMENODE</value>
          <description>The hostname of the RM.</description>
      </property>
  </configuration>" > $HADOOP_CONF_DIR/yarn-site.xml

  echo "192.168.1.112
  192.168.1.113" > $HADOOP_CONF_DIR/slaves

  sed -i -e "s/\=\${JAVA_HOME}/\=\/usr\/lib\/jvm\/java-8-oracle/g" $HADOOP_CONF_DIR/hadoop-env.sh
  sed -i -e "s/\=\${JAVA_HOME}/\=\/usr\/lib\/jvm\/java-8-oracle/g" /home/hbcs/hadoop/hadoop-2.5.1/etc/hadoop/hadoop-env.sh
fi
