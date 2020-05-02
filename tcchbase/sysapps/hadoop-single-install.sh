#!/bin/sh
hadoop_version=2.8.4
hadoop_local=$HOME/hadoop
#hadoop_rootdir=$hadoop_local/rootdir
#hbase_zookeeper=$hbase_local/zookeeper
echo "Get Hadoop compiled"
wget http://archive.apache.org/dist/hadoop/common/hadoop-$hadoop_version/hadoop-$hadoop_version.tar.gz
echo "Get Hadoop source"
wget http://archive.apache.org/dist/hadoop/common/hadoop-$hadoop_version/hadoop-$hadoop_version-src.tar.gz

echo "Move to $hadoop_local"
mkdir -p $hadoop_local

cp hadoop-$hadoop_version.tar.gz $hadoop_local
cp hadoop-$hadoop_version-src.tar.gz $hadoop_local


tar -zxf $hadoop_local/hadoop-$hadoop_version.tar.gz -C $hadoop_local
tar -zxf $hadoop_local/hadoop-$hadoop_version-src.tar.gz -C $hadoop_local

HADOOP_PREFIX=$hadoop_local/hadoop-$hadoop_version
HADOOP_HOME=$HADOOP_PREFIX
HADOOP_COMMON_HOME=$HADOOP_PREFIX
HADOOP_CONF_DIR=$HADOOP_PREFIX/etc/hadoop
HADOOP_HDFS_HOME=$HADOOP_PREFIX
HADOOP_MAPRED_HOME=$HADOOP_PREFIX
HADOOP_YARN_HOME=$HADOOP_PREFIX

echo "Configuring HDFS $HADOOP_CONF_DIR/hdfs-site.xml"
echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
<configuration>
    <property>
        <name>dfs.datanode.data.dir</name>
        <value>file://$hadoop_local/hadoop-$hadoop_version/hdfs/datanode</value>
        <description>Comma separated list of paths on the local filesystem of a DataNode where it should store its blocks.</description>
    </property>

    <property>
        <name>dfs.namenode.name.dir</name>
        <value>file://$hadoop_local/hadoop-$hadoop_version/hdfs/namenode</value>
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
