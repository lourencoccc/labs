package com.cloudec.hbcs.cassandra;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cloudec.hbcs.ICommand;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */
public class CsMain {

  static Logger logger = Logger.getLogger(CsMain.class);
  static Map<String, ICommand> commands = new HashMap<>();

  static {
    commands.put("tableLoader", new CsTableLoader());
    commands.put("query1", (args) -> {
      try (CsQuery q = new CsQuery1()) {
        q.exec(args);
      }
    });
    commands.put("query1Normal", (args) -> {
      try (CsQuery q = new CsQuery1Normal()) {
        q.exec(args);
      }
    });
    commands.put("query2", (args) -> {
      try (CsQuery q = new CsQuery2()) {
        q.exec(args);
      }
    });
    commands.put("query2Normal", (args) -> {
      try (CsQuery q = new CsQuery2Normal()) {
        q.exec(args);
      }
    });
    commands.put("query3", (args) -> {
      try (CsQuery q = new CsQuery3()) {
        q.exec(args);
      }
    });
    commands.put("query3Normal", (args) -> {
      try (CsQuery q = new CsQuery3Normal()) {
        q.exec(args);
      }
    });
    commands.put("query4", (args) -> {
      try (CsQuery q = new CsQuery4()) {
        q.exec(args);
      }
    });
    commands.put("query4Normal", (args) -> {
      try (CsQuery q = new CsQuery4Normal()) {
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
