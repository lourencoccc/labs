package com.cloudec.hbcs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-17
 */
public class HbcsUtils {

  /**
   * @param arguments Arguments from runtime
   * @return Map [command:"", environment:"", queryName:""]
   */
  public static Map<String, String> processQueryCommandArgs(String... arguments) {
    Map<String, String> params = new HashMap<>();
    if (arguments == null || arguments.length < 4) {
      throw new IllegalArgumentException(
          "Invalid Command. Expected: query [cluster | local] {id}");
    } else {
      params.put("command", arguments[0]);
      params.put("environment", arguments[1]);
      params.put("label", arguments[2]);
      params.put("attempt", arguments[3]);
    }
    return params;
  }

  /**
   * @param arguments Arguments from runtime
   * @return Map [command:"", environment:"", configFilwePath:"", datasetPath:""]
   */
  public static Map<String, String> processTableLoaderCommandArgs(String... arguments) {
    Map<String, String> params = new HashMap<>();
    validateTableLoader(arguments);
    params.put("command", arguments[0]);
    params.put("environment", arguments[1]);
    params.put("configFilePath", arguments[2]);
    params.put("datasetPath", arguments[3]);
    if (arguments != null && arguments.length == 5) {
      params.put("datasetNameFolder", arguments[3]);
    }
    return params;
  }

  public static void validateTableLoader(String... arguments) {
    if (arguments == null || arguments.length < 4) {
      throw new IllegalArgumentException(
          "Invalid Command. Expected: tableLoader [cluster|local] {configFilePath} {datasetPath}");
    }
    HbcsFileUtils.verifyIfExist(arguments[2]);
    HbcsFileUtils.verifyIfExist(arguments[3]);
  }

}
