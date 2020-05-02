package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsEnvironment;
import com.cloudec.hbcs.HbcsException;
import com.cloudec.hbcs.HbcsReport;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import java.io.Closeable;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-19
 */
public class CsQueryExecutor implements Closeable, Serializable {

  protected Cluster cluster;
  protected Session session;

  final HbcsEnvironment environment;

  public CsQueryExecutor(HbcsEnvironment environment) {
    super();
    this.environment = environment;
    try {
      CsConfig csConfig = CsConfig.create(environment);
      this.cluster = Cluster.builder().addContactPoints(csConfig.getContacPoints())
          .withPort(csConfig.getPort()).build();
      System.out.printf("Connected to cluster: %s%n", this.cluster.getMetadata().getClusterName());
      this.session = cluster.connect();
    } catch (Exception e) {
      throw new HbcsException("hbcs_erro_connect_cassandra", e);
    }
  }

  public ResultSet execute(String cql, HbcsReport report) {
    Instant start = Instant.now();
    ResultSet resultSet = session.execute(cql);
    Instant end = Instant.now();
    report.configureDuration(start, end);
    return resultSet;
  }

  @Override
  public void close() {
    if (this.session != null || this.cluster != null) {
      this.session.close();
      this.cluster.close();
    }
  }
}
