package com.cloudec.hbcs.hbase;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cloudec.hbcs.ICommand;

public class HbMain {

  static Logger logger = Logger.getLogger(HbMain.class);
  static Map<String, ICommand> commands = new HashMap<>();

  static {
    commands.put("tableLoader", new HbTableLoader());
    commands.put("query1", (args) -> {
      try (HbQuery q = new HbQuery1()) {
        q.exec(args);
      }
    });
    commands.put("query1Normal", (args) -> {
      try (HbQuery q = new HbQuery1Normal()) {
        q.exec(args);
      }
    });
    commands.put("query2", (args) -> {
      try (HbQuery q = new HbQuery2()) {
        q.exec(args);
      }
    });
    commands.put("query2Normal", (args) -> {
      try (HbQuery q = new HbQuery2Normal()) {
        q.exec(args);
      }
    });
    commands.put("query3", (args) -> {
      try (HbQuery q = new HbQuery3()) {
        q.exec(args);
      }
    });
    commands.put("query3Normal", (args) -> {
      try (HbQuery q = new HbQuery3Normal()) {
        q.exec(args);
      }
    });
    commands.put("query4", (args) -> {
      try (HbQuery q = new HbQuery4()) {
        q.exec(args);
      }
    });
    commands.put("query4Normal", (args) -> {
      try (HbQuery q = new HbQuery4Normal()) {
        q.exec(args);
      }
    });
    commands.put("testConn", (args) -> {
      try (HbTestConnection q = new HbTestConnection()) {
        q.exec(args);
      }
    });
  }

  public static void main(String... args) throws Exception {
    if (args != null && args.length > 0) {
      commands.get(args[0]).exec(args);
    }
  }

}
