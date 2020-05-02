package com.cloudec.hbcs.hbase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;

public class HbResultParser {


  /**
   * 
   * @param fields Map<String, String> ["familly:colunm": ["type":class]]
   * @param resultScanner
   * @return
   */
  public static Map<String, String> parse(final List<String> fields,
      final ResultScanner resultScanner) {
    
    Map<String, String> mapResult = new HashMap<>();
    
    for (Result result : resultScanner) {
      for (String key : fields) {
        String[] colunmName = key.split(":");
        byte[] value = result.getValue(Bytes.toBytes(colunmName[0]), Bytes.toBytes(colunmName[1]));
        
        //TODO considerar tipo do dado passado no modelo
        
        mapResult.put(key, Bytes.toString(value));
      }
    }
    
    return mapResult;
  }
  
  

  

}
