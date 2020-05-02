package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsQueryAbstract;
import com.cloudec.hbcs.HbcsReport;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import org.apache.log4j.Logger;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */
public abstract class CsQuery extends HbcsQueryAbstract {

  static Logger logger = Logger.getLogger(CsQuery.class);

  protected CsQueryExecutor csQueryExecutor;
  protected ResultSet resultSet;

  public CsQuery(String queryId, String dataModel) {
    super("cassandra", queryId, dataModel);
  }

  public abstract String createDefaultQuery();

  public void processSelect() {
    HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
    this.resultSet = csQueryExecutor.execute(createDefaultQuery(), hbcsReport);
    reports.add(hbcsReport);
    processResult();
  }

  public void processResult(){
    //nada a fazer
  }

  public void show() {
    System.out.println("***************** HBCS - CASSANDRA - RESULT *****************");
    int count = 0;
    if (resultSet != null) {
      for (Row row : resultSet) {
        count++;
      }
    }
    System.out.println("RESULT COUNT: "+count);
  }

  @Override
  public void connect() {
    this.csQueryExecutor = new CsQueryExecutor(environment);
  }

  public void close() {
    csQueryExecutor.close();
  }

}
