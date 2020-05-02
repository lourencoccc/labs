package com.cloudec.hbcs;

import java.util.List;
import java.util.Map;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-31
 */
public class HbcsTableValidator {

  public static boolean hasAllPropertiesInMap(final List<String> props,
      final Map<String, String> map) {
    return props == null
        || props.isEmpty()
        || map.keySet().containsAll(props);
  }

  public static boolean hasAllNotEmptyColumns(final HbcsConfigurationTable table,
      final Map<String, String> mapRow) {
    return hasAllPropertiesInMap(table.getNotEmptyColumns(), mapRow);
  }

  public static boolean hasAllKeyColumns(final HbcsConfigurationTable table,
      final Map<String, String> mapRow) {
    return hasAllPropertiesInMap(table.getRowKeys(), mapRow);
  }

  public static boolean hasAllRequiredColumns(final HbcsConfigurationTable table,
      final Map<String, String> mapRow) {
    return hasAllNotEmptyColumns(table, mapRow) && hasAllKeyColumns(table, mapRow);
  }

}
