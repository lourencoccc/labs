package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsEnvironment;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-18
 */
public class HbConfigFactory {

  private static final String CLUSTER_MASTER_PORT = "2181";
  private static final String CLUSTER_MASTER_IP = "192.168.1.111";

  public static Configuration createHBaseConf(String environment) {
    return createHBaseConf(HbcsEnvironment.valueOf(environment.toUpperCase()));
  }

  public static Configuration createHBaseConf(HbcsEnvironment environment) {
    Configuration conf = HBaseConfiguration.create();
    if (HbcsEnvironment.CLUSTER.equals(environment)) {
      conf.set("hbase.zookeeper.property.clientPort", CLUSTER_MASTER_PORT);
      conf.set("hbase.zookeeper.quorum", CLUSTER_MASTER_IP);
      conf.set("hbase.rpc.timeout", "14800000");
      conf.set("hbase.client.scanner.timeout.period", "14800000");
    }
    return conf;
  }

}
