package com.cloudec.hbcs

import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-02-23
 */
class DatasetReaderSpec extends Specification {

  def "should read all rows from table"() {
    given:
    DatasetReader dataset = new DatasetReader()
    def results = []

    when:
    dataset.readXmlTable(xmlInputStream(), { results << it })

    then:
    results.size() == 8
    and:
    results[0]['Id'] == '1'
    and:
    results[1]['Id'] == '2'
  }

  def xmlInputStream() {
    DatasetReaderSpec.class.getClassLoader().getResourceAsStream("Tags.xml")
  }

}
