package com.cloudec.hbcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;


/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
public class HbcsConfigurationFactory {

  public static HbcsConfiguration create(InputStream conf) {
    return (HbcsConfiguration) yamlParser().load(conf);
  }

  public static HbcsConfiguration create(File conf) {
    HbcsConfiguration hbcsConf = null;
    try(InputStream confInput = new FileInputStream(conf)){
      hbcsConf = (HbcsConfiguration) yamlParser().load(confInput);
    } catch (IOException ex) {
      throw new HbcsException("erro_configuration_file_not_found", ex);
    }
    return hbcsConf;
  }

  public static HbcsConfiguration create(String conf) {
    return (HbcsConfiguration) yamlParser().load(conf);
  }

  private static Yaml yamlParser(){
    Constructor constructor = new Constructor(HbcsConfiguration.class);
    TypeDescription confDesc = new TypeDescription(HbcsConfiguration.class);
    confDesc.putListPropertyType("tables", HbcsConfigurationTable.class);
    TypeDescription tableDesc = new TypeDescription(
        HbcsConfigurationTable.class);
    tableDesc.putListPropertyType("aggregates", HbcsConfigurationTable.class);
    constructor.addTypeDescription(confDesc);
    constructor.addTypeDescription(tableDesc);
    return new Yaml(constructor);
  }

}
