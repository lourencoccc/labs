package com.cloudec.hbcs;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public class HbcsH2Database implements Closeable {

  private static final String URL = "jdbc:h2:~/hbcsdb";
  private static final String DRIVER_CLASS = "org.h2.Driver";
  private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS hbcs_results (\n"
      + "  id BIGINT NOT NULL auto_increment,\n"
      + "  label VARCHAR(200) NOT NULL,\n"
      + "  attempt INT NOT NULL,\n"
      + "  database VARCHAR(50) NOT NULL,\n"
      + "  datamodel VARCHAR (50) NOT NULL,\n"
      + "  queryid VARCHAR (50) NOT NULL,\n"
      + "  environment VARCHAR (50),\n"
      + "  processor VARCHAR (50),\n"
      + "  duration VARCHAR (50),\n"
      + "  durationmillis BIGINT,\n"
      + "  durationseconds BIGINT,\n"
      + "  insertdate TIMESTAMP DEFAULT NOW(),\n"
      + "  PRIMARY KEY (id)"
      + ");";
  private Connection connection;

  public HbcsH2Database() {
    getConnection();
  }

  public Connection getConnection() {
    try {
      Class.forName(DRIVER_CLASS);
      if (this.connection == null) {
        this.connection = DriverManager.getConnection(URL);
        initdb();
      }
    } catch (ClassNotFoundException | SQLException ex) {
      ex.printStackTrace();
    }
    return connection;
  }

  private void initdb() {
    try {
      Statement statement = getConnection().createStatement();
      statement.execute(CREATE_TABLE);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void insertHbcsReport(Collection<HbcsReport> reports) {
    if (reports != null) {
      for (HbcsReport report : reports) {
        insertHbcsReport(report);
      }
    }
  }

  public void insertHbcsReport(final HbcsReport hbcsReport) {
    String insert = "INSERT INTO hbcs_results SET\n"
        + "  label = ?,"
        + "  attempt = ?,"
        + "  database = ? ,"
        + "  datamodel = ?,"
        + "  queryid = ?,"
        + "  environment =  ?,"
        + "  processor = ?,"
        + "  duration = ?,"
        + "  durationmillis = ?,"
        + "  durationseconds =  ?;";
    try {
      PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
      preparedStatement.setString(1, hbcsReport.getLabel());
      preparedStatement.setInt(2, hbcsReport.getAttempt());
      preparedStatement.setString(3, hbcsReport.getDatabase());
      preparedStatement.setString(4, hbcsReport.getDataModel());
      preparedStatement.setString(5, hbcsReport.getQueryId());
      preparedStatement.setString(6, hbcsReport.getEnvironment());
      preparedStatement.setString(7, hbcsReport.getProcessor());
      preparedStatement.setString(8, hbcsReport.getDuration());
      preparedStatement.setLong(9, hbcsReport.getDurationMillis());
      preparedStatement.setLong(10, hbcsReport.getDurationSeconds());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void close() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
