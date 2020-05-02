#!/bin/sh
hbase_version=2.1.0
hbase_local=$HOME/hbase
hbase_targz=hbase-$hbase_version-bin.tar.gz
hbase_rootdir=$hbase_local/rootdir
hbase_zookeeper=$hbase_local/zookeeper
echo "Download $hbase_targz"
wget http://archive.apache.org/dist/hbase/$hbase_version/$hbase_targz
mkdir -p $hbase_rootdir
mkdir -p $hbase_zookeeper
mv $hbase_targz $hbase_local
tar -zxf $HOME/hbase/$hbase_targz -C $hbase_local
#hbase standalone mode
echo "<?xml version=\"1.0\"?>
<?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>
<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file://$hbase_rootdir</value>
  </property>
  <property>
    <name>hbase.zookeeper.property.dataDir</name>
    <value>$hbase_zookeeper</value>
  </property>
</configuration>" > $hbase_local/hbase-$hbase_version/conf/hbase-site.xml
