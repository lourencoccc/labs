package com.cloudec.hbcs;


import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-02-17
 */
public class HbcsConfigurationTable {

  private String name;
  private String nameSpace;
  private String datasetName;
  private String datasetPath;
  private String sourceFile;
  private String keyField;
  private String cfName;
  private String refKeyField;
  private List<String> rowKeys;
  private List<String> columns;
  private List<HbcsConfigurationTable> aggregates;
  private Map<String, String> cassandraColumnTypes;
  private List<String> notEmptyColumns;

  public String sourcePath() {
    return this.datasetPath + File.separator + this.sourceFile;
  }

  public String columnType(String columnName) {
    String type = null;
    if (!getCassandraColumnTypes().isEmpty()) {
      type = this.cassandraColumnTypes.get(columnName);
    }
    return type != null ? type : "text";
  }

  public boolean isTextOrTimestamp(String columnName) {
    String type = columnType(columnName);
    return type == "text" || type == "timestamp" ? true : false;
  }

  public String tableName(HbcsTypeDatabase type) {
    String referenceSymbol = ".";
    if (HbcsTypeDatabase.HBASE == type) {
      referenceSymbol = ":";
    }
    return this.nameSpace + referenceSymbol + this.name;
  }

  public Set<String> columnSet() {
    return new HashSet<>(getColumns());
  }

  // Gets and Sets

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameSpace() {
    return this.nameSpace;
  }

  public void setNameSpace(String nameSpace) {
    this.nameSpace = nameSpace;
  }

  public String getDatasetPath() {
    return this.datasetPath;
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

  public String getSourceFile() {
    return this.sourceFile;
  }

  public void setSourceFile(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  public String getKeyField() {
    return this.keyField;
  }

  public void setKeyField(String keyField) {
    this.keyField = keyField;
  }

  public String getCfName() {
    return this.cfName;
  }

  public void setCfName(String cfName) {
    this.cfName = cfName;
  }

  public String getRefKeyField() {
    return this.refKeyField;
  }

  public void setRefKeyField(String refKeyField) {
    this.refKeyField = refKeyField;
  }

  public List<String> getRowKeys() {
    return this.rowKeys != null ? this.rowKeys : emptyList();
  }

  public void setRowKeys(List<String> rowKeys) {
    this.rowKeys = rowKeys;
  }

  public List<String> getColumns() {
    return this.columns != null ? this.columns : emptyList();
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }

  public List<HbcsConfigurationTable> getAggregates() {
    return this.aggregates != null ? this.aggregates : emptyList();
  }

  public void setAggregates(List<HbcsConfigurationTable> aggregates) {
    this.aggregates = aggregates;
  }

  public boolean hasAggregates() {
    return this.aggregates != null && this.aggregates.size() > 0;
  }

  public Map<String, String> getCassandraColumnTypes() {
    return this.cassandraColumnTypes != null ? this.cassandraColumnTypes : emptyMap();
  }

  public void setCassandraColumnTypes(Map<String, String> cassandraColumnTypes) {
    this.cassandraColumnTypes = cassandraColumnTypes;
  }

  public List<String> getNotEmptyColumns() {
    return notEmptyColumns;
  }

  public void setNotEmptyColumns(List<String> notEmptyColumns) {
    this.notEmptyColumns = notEmptyColumns;
  }
}
