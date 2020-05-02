#!/bin/sh
HBASE_HOME=/home/hbcs/hbase/hbase-1.2.6
sshpass -p "hbcs2000" ssh hbcs@192.168.1.111 "$HBASE_HOME/bin/stop-hbase.sh"

# HBASE_VERSION=1.2.6
# SLAVES="192.168.1.112 192.168.1.113 192.168.1.114"
# for host in $SLAVES
# do
#   echo "HBCS-HBASE Stop regionservers in $host"
#   sshpass -p "hbcs2000" ssh hbcs@$host "sh $HBASE_HOME/bin/hbase-daemon.sh stop regionserver"
# done
