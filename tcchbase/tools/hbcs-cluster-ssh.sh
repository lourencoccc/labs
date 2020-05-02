#!/bin/sh
echo 'SSH configure cluster'
HOSTS="192.168.1.111 192.168.1.112 192.168.1.113 192.168.1.114"
SLAVES="192.168.1.112 192.168.1.113 192.168.1.114"
MAIN=192.168.1.111
CMD_SSH_KEYGEN="rm -fr ~/.ssh;
  ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa;
  cat ~/.ssh/id_rsa.pub > ~/.ssh/authorized_keys;
  ssh-keyscan -H localhost >> .ssh/known_hosts;
  ssh-keyscan -H 127.0.0.1 >> .ssh/known_hosts;
  ssh-keyscan -H 0.0.0.0 >> .ssh/known_hosts;
  ssh-keyscan -H \`hostname\` >> .ssh/known_hosts;
  ssh-keyscan -H \`ip route get 1 | awk '{print \$NF;exit}'\` >> .ssh/known_hosts"

for host in $HOSTS
do
 sshpass -p "hbcs2000" ssh hbcs@$host $CMD_SSH_KEYGEN
done

sshpass -p "hbcs2000" scp hbcs@192.168.1.111:/home/hbcs/.ssh/id_rsa.pub /tmp/hadoop_master_key
sshpass -p "hbcs2000" scp hbcs@192.168.1.112:/home/hbcs/.ssh/id_rsa.pub /tmp/hbcssrv2_key
sshpass -p "hbcs2000" scp hbcs@192.168.1.113:/home/hbcs/.ssh/id_rsa.pub /tmp/hbcssrv3_key
sshpass -p "hbcs2000" scp hbcs@192.168.1.114:/home/hbcs/.ssh/id_rsa.pub /tmp/hbcssrv4_key

CMD_SSH_KEYS="cat ~/master_key >> ~/.ssh/authorized_keys;
  cat ~/hbcssrv2_key >> ~/.ssh/authorized_keys;
  cat ~/hbcssrv3_key >> ~/.ssh/authorized_keys;
  cat ~/hbcssrv4_key >> ~/.ssh/authorized_keys;
";
for slave in $HOSTS
do
 echo "cp hadoop_master_key to hbcs@$slave:/home/hbcs/master_key"
 sshpass -p "hbcs2000" scp /tmp/hadoop_master_key hbcs@$slave:/home/hbcs/master_key
 sshpass -p "hbcs2000" scp /tmp/hbcssrv2_key hbcs@$slave:/home/hbcs/hbcssrv2_key
 sshpass -p "hbcs2000" scp /tmp/hbcssrv3_key hbcs@$slave:/home/hbcs/hbcssrv3_key
 sshpass -p "hbcs2000" scp /tmp/hbcssrv4_key hbcs@$slave:/home/hbcs/hbcssrv4_key
 sshpass -p "hbcs2000" ssh hbcs@$slave $CMD_SSH_KEYS
 for hostname1 in "hbcssrv1 hbcssrv2 hbcssrv3 hbcssrv4"
 do
   sshpass -p "hbcs2000" ssh hbcs@$slave "ssh-keyscan -H $hostname1 >> .ssh/known_hosts"
 done
 for hostname2 in $HOSTS
 do
   sshpass -p "hbcs2000" ssh hbcs@$slave "ssh-keyscan -H $hostname2 >> .ssh/known_hosts"
 done
done
