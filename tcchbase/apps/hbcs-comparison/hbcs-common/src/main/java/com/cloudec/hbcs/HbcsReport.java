package com.cloudec.hbcs;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-17
 */
public class HbcsReport implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private String label;
  private int attempt;
  private String database;
  private String dataModel;
  private String queryId;
  private String environment;
  private String processor;

  /**
   * ISO-8601
   */
  private String duration;
  private Long durationMillis;
  private Long durationSeconds;

  /**
   *
   * @param queryId
   * @return
   */
  public static HbcsReport create(String queryId) {
    HbcsReport hbcsReport = new HbcsReport();
    hbcsReport.setQueryId(queryId);
    return hbcsReport;
  }

  /**
   *
   * @param queryId
   * @param dataModel
   * @param environment
   * @return
   */
  public static HbcsReport create(String queryId, String dataModel,
      String environment, String processor) {
    HbcsReport hbcsReport = new HbcsReport();
    hbcsReport.setQueryId(queryId);
    hbcsReport.setDataModel(dataModel);
    hbcsReport.setEnvironment(environment);
    hbcsReport.setProcessor(processor);
    return hbcsReport;
  }

  public int getAttempt() {
    return attempt;
  }

  public void setAttempt(int attempt) {
    this.attempt = attempt;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public String getDataModel() {
    return dataModel;
  }

  public void setDataModel(String dataModel) {
    this.dataModel = dataModel;
  }

  public String getQueryId() {
    return queryId;
  }

  public void setQueryId(String queryId) {
    this.queryId = queryId;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Long getDurationMillis() {
    return durationMillis;
  }

  public void setDurationMillis(Long durationMillis) {
    this.durationMillis = durationMillis;
  }

  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public Long getDurationSeconds() {
    return durationSeconds;
  }

  public void setDurationSeconds(Long durationSeconds) {
    this.durationSeconds = durationSeconds;
  }

  public void configureDuration(Instant start, Instant end) {
    this.setDuration(Duration.between(start, end).toString());
    this.setDurationMillis(ChronoUnit.MILLIS.between(start, end));
    this.setDurationSeconds(ChronoUnit.SECONDS.between(start, end));
  }

  @Override
  public String toString() {
    return "HbcsReport{" +
        "database='" + database + '\'' +
        "dataModel='" + dataModel + '\'' +
        ", queryId='" + queryId + '\'' +
        ", environment='" + environment + '\'' +
        ", processor='" + processor + '\'' +
        ", duration='" + duration + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HbcsReport)) {
      return false;
    }

    HbcsReport that = (HbcsReport) o;

    if (getDataModel() != null ? !getDataModel().equals(that.getDataModel())
        : that.getDataModel() != null) {
      return false;
    }
    if (getQueryId() != null ? !getQueryId().equals(that.getQueryId())
        : that.getQueryId() != null) {
      return false;
    }
    if (getEnvironment() != null ? !getEnvironment().equals(that.getEnvironment())
        : that.getEnvironment() != null) {
      return false;
    }
    if (getDuration() != null ? !getDuration().equals(that.getDuration())
        : that.getDuration() != null) {
      return false;
    }
    return getDurationMillis() != null ? getDurationMillis().equals(that.getDurationMillis())
        : that.getDurationMillis() == null;
  }

  @Override
  public int hashCode() {
    int result = getDataModel() != null ? getDataModel().hashCode() : 0;
    result = 31 * result + (getQueryId() != null ? getQueryId().hashCode() : 0);
    result = 31 * result + (getEnvironment() != null ? getEnvironment().hashCode() : 0);
    result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
    result = 31 * result + (getDurationMillis() != null ? getDurationMillis().hashCode() : 0);
    return result;
  }
}
