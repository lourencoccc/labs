package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsQueryAbstract;
import com.cloudec.hbcs.HbcsReport;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

public abstract class HbQuery extends HbcsQueryAbstract {

  protected String tableName;

  protected HbQueryScanner hbQueryScanner;

  protected ResultScanner resultScanner;

  public HbQuery(String queryId, String dataModel) {
    super("hbase", queryId, dataModel);
  }

  public abstract Scan createScan();

  public void processSelect() {
    HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
    this.resultScanner = hbQueryScanner.scan(tableName, createScan(), hbcsReport);
    reports.add(hbcsReport);
    processResult();
  }

  public abstract void processResult();

  public void show() {
    System.out.println("***************** HBCS - HBASE - RESULT *****************");
    int count = 0;
    if (resultScanner != null) {
      for (Result result : resultScanner) {
        count++;
      }
    }
    System.out.println("RESULT COUNT: " + count);
  }

  public void connect(){
    this.hbQueryScanner = new HbQueryScanner(environment);
  }

  @Override
  public void close() {
    hbQueryScanner.close();
    resultScanner.close();
  }

}
