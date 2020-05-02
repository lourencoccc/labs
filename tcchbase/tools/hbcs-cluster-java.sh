#!/bin/sh
CMD_INSTALL_JAVA="
  apt-get install software-properties-common -y;
  add-apt-repository \"deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main\" -y;
  apt-get update;
  apt-get install oracle-java8-installer -y;
  echo 'JAVA_HOME=\"/usr/lib/jvm/java-8-oracle\"' >> /etc/environment;
"
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113 192.168.1.114"
for host in $HOSTS
do
 sshpass -p "hbcs2000" ssh hbcs@$host "echo '$CMD_INSTALL_JAVA' >> \$HOME/install-java.sh"
done
