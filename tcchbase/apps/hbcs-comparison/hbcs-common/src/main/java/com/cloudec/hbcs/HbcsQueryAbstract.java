package com.cloudec.hbcs;

import java.io.Closeable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public abstract class HbcsQueryAbstract implements ICommand, Closeable {

  /**
   * Database name, HBase or Cassandra
   */
  protected final String database;

  /**
   * Query ID
   */
  protected final String queryId;

  /**
   * Data model, relational or query oriented
   */
  protected final String dataModel;

  /**
   * Label for mark query execution
   */
  protected String label;

  /**
   * Attempt to query run
   */
  protected int attempt;
  protected HbcsEnvironment environment;
  protected List<HbcsReport> reports = new ArrayList<>();

  /**
   *
   * @param database
   * @param queryId
   * @param dataModel
   */
  public HbcsQueryAbstract(String database, String queryId, String dataModel) {
    this.database = database;
    this.queryId = queryId;
    this.dataModel = dataModel;
  }

  /**
   *
   * @param processor
   * @return
   */
  protected HbcsReport createReport(HbcsProcessor processor) {
    HbcsReport hbcsReport = new HbcsReport();
    hbcsReport.setLabel(label);
    hbcsReport.setAttempt(attempt);
    hbcsReport.setQueryId(queryId);
    hbcsReport.setDataModel(dataModel);
    hbcsReport.setEnvironment(environment.name());
    hbcsReport.setDatabase(database);
    hbcsReport.setProcessor(processor.name());
    return hbcsReport;
  }

  /**
   *
   * @param processor
   * @param start
   * @param end
   */
  protected void addReport(HbcsProcessor processor, Instant start, Instant end) {
    HbcsReport hbcsReport = createReport(processor);
    hbcsReport.configureDuration(start, end);
    reports.add(hbcsReport);
  }

  /**
   *
   */
  protected void printReport() {
    System.out.println("***************** HBCS - REPORT *****************");
    for (HbcsReport report : reports) {
      System.out.println(report);
    }
  }

  /**
   *
   */
  public abstract void connect();

  /**
   *
   */
  public abstract void processSelect();

  /**
   *
   */
  public abstract void show();

  /**
   *
   */
  public void saveReports(){
    try(HbcsH2Database hbcsH2Database = new HbcsH2Database()){
      hbcsH2Database.insertHbcsReport(reports);
    }
  }

  /**
   *
   * @param args
   */
  public void exec(String... args) {
    Map<String, String> params = HbcsUtils.processQueryCommandArgs(args);
    environment = HbcsEnvironment.valueOf(params.get("environment").toUpperCase());
    this.label = params.get("label");
    this.attempt = Integer.valueOf(params.get("attempt"));
    this.connect();
    this.processSelect();
    this.show();
    this.printReport();
    this.saveReports();
    try {
      this.close();
    } catch (Exception ex) {
      throw new HbcsException("hbcs_erro_close", ex);
    }
  }

}
