package com.cloudec.hbcs;

import java.util.List;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-04-26
 */
public class HbcsConfiguration {

  private String datasetPath;
  private String datasetName;
  private String nameSpace;
  private List<HbcsConfigurationTable> tables;


  public String getNameSpace() {
    return nameSpace;
  }

  public void setNameSpace(String nameSpace) {
    this.nameSpace = nameSpace;
  }

  public List<HbcsConfigurationTable> getTables() {
    return tables;
  }

  public void setTables(List<HbcsConfigurationTable> tables) {
    this.tables = tables;
  }

  public String getDatasetPath() {
    return datasetPath;
  }

  public void setDatasetPath(String datasetPath) {
    this.datasetPath = datasetPath;
  }

  public String getDatasetName() {
    return datasetName;
  }

  public void setDatasetName(String datasetName) {
    this.datasetName = datasetName;
  }

  public void updateDataset(String datasetName, String datasetPath) {
    this.datasetName = datasetName;
    this.datasetPath = datasetPath;
    if (hasTables()) {
      for (HbcsConfigurationTable table : this.tables) {
        table.setDatasetPath(datasetPath);
        table.setDatasetName(datasetName);
        if(table.hasAggregates()){
          for (HbcsConfigurationTable tableAggre : table.getAggregates()) {
            tableAggre.setDatasetPath(datasetPath);
            tableAggre.setDatasetName(datasetName);
          }
        }

      }
    }
  }

  public boolean hasTables() {
    return this.tables != null && this.tables.size() > 0;
  }
}
