package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsEnvironment;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public class CsConfig {

  private static final int PORT_DEFAULT = 9042;
  private static final String[] CLUSTER_IPS = new String[]{"192.168.1.111"};
  private static final String[] LOCAL_IPS = new String[]{"127.0.0.1"};

  private final String[] contacPoints;
  private final int port;

  public CsConfig(String[] contacPoints, int port) {
    this.contacPoints = contacPoints;
    this.port = port;
  }

  public static CsConfig create(String environment) {
    return create(HbcsEnvironment.valueOf(environment.toUpperCase()));
  }

  public static CsConfig create(HbcsEnvironment environment) {
    CsConfig csConfig;
    if (HbcsEnvironment.CLUSTER.equals(environment)) {
      csConfig = new CsConfig(CLUSTER_IPS, PORT_DEFAULT);
    } else {
      //local
      csConfig = new CsConfig(LOCAL_IPS, PORT_DEFAULT);
    }
    return csConfig;
  }

  public String[] getContacPoints() {
    return contacPoints;
  }

  public int getPort() {
    return port;
  }
}
