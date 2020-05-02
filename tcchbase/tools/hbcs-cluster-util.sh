#!/bin/sh

echo "Configure IP"

echo "Configures all hosts in cluster"

echo '192.168.1.111   hbcssrv1
192.168.1.112   hbcssrv2
192.168.1.113   hbcssrv3
192.168.1.114   hbcssrv4' > /etc/hosts

# su -c "echo '192.168.1.111   hbcssrv1
# 192.168.1.112   hbcssrv2
# 192.168.1.113   hbcssrv3
# 192.168.1.114   hbcssrv4' > /etc/hosts"


echo "Configure TIME from http://www.pool.ntp.org/zone/south-america"
# http://www.pool.ntp.org/zone/south-america
apt-get install ntpdate -y
ntpdate 3.br.pool.ntp.org
hwclock --systohc

# su -c 'apt-get install ntpdate -y'
# su -c 'ntpdate 3.br.pool.ntp.org'
# su -c 'hwclock --systohc'

16000
