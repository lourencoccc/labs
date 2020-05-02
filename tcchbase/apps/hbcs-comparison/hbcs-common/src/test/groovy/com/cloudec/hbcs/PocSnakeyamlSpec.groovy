package com.cloudec.hbcs

import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
class PocSnakeyamlSpec extends Specification {

  def "should convert to simple list"() {
    setup:
    Yaml yaml = new Yaml();
    def document = """
    - joao
    - rose
    - heitor
    """

    when:
    List<String> yamlList = (List<String>) yaml.load(document)

    then:
    ['joao', 'rose', 'heitor'] == yamlList
  }

  def "should convert map with list of maps"() {
    setup:
    Yaml yaml = new Yaml();
    def document = """
    type: AGGREGATE
    tables:
      - name: Posts
        source: Posts.xml
        rowKey: Id
    """

    when:
    Map config = (Map) yaml.load(document)

    then:
    config.type == 'AGGREGATE'
    and:
    config.tables[0].name == 'Posts'
  }

  def "should convert complex object"() {
    setup:
    Yaml yaml = new Yaml();
    def document = """
    name: aggregate
    tables:
      - name: Posts
        source: Posts.xml
        rowKey: Id
        hasMany:
          - name: PostHistory
            source: PostHistory.xml
            id: Id
            referenceId: PostId
    """

    when:
    HbcsConfig config = (HbcsConfig) yaml.load(document)

    then:
    config.name == 'aggregate'
    and:
    config.tables.size() == 1
    and:
    config.tables[0].name == 'Posts'
    config.tables[0].hasMany[0].name == 'PostHistory'
    config.tables[0].hasMany[0].id == 'Id'
    config.tables[0].hasMany[0].referenceId == 'PostId'
  }

  def yamlInputStream() {
    DatasetReaderSpec.class.getClassLoader().getResourceAsStream(
        "loadconfig-normal.yml")
  }

  class HbcsConfig {
    String name
    List<Map> tables

    String toString() {
      "$name, $tables"
    }
  }
}
