package com.cloudec.hbcs

import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-18
 */
class HbcsUtilsSpec extends Specification {

  def tmpFileName = 'hbcstest.yaml'
  def tmpDir = 'hbcstest'

  def setup() {
    def file = new File(makePath(tmpFileName))
    file.write 'hbcs test file.'
    def fileDir = new File(makePath(tmpDir))
    fileDir.mkdir()
  }

  def cleanup() {
    new File(makePath(tmpFileName)).delete()
    new File(makePath(tmpDir)).deleteDir()
  }

  def "should extract valid params from tableLoader command"() {
    given:
    String[] args = [
        'tableLoader', 'cluster', makePath('hbcstest.yaml'), makePath('hbcstest')
    ]
    when:
    def params = HbcsUtils.processTableLoaderCommandArgs(args)

    then:
    params.command == args[0]
    and:
    params.environment == args[1]
    and:
    params.configFilePath == args[2]
    and:
    params.datasetPath == args[3]
  }

  def "should throw illegal argument exception for tableLoader command"() {
    when:
    HbcsUtils.processTableLoaderCommandArgs(args)

    then:
    thrown(resultException)

    where:
    args               || resultException
    null               || IllegalArgumentException
    '1,2'.split(',')   || IllegalArgumentException
    '1,2,3'.split(',') || IllegalArgumentException
  }

  def "should extract valid params from query command"() {
    given:
    String[] args = [
        'query', 'cluster', 'query3', '1'
    ]

    when:
    def params = HbcsUtils.processQueryCommandArgs(args)

    then:
    params.command == args[0]
    and:
    params.environment == args[1]
    and:
    params.label == args[2]
  }

  def "should throw illegal argument exception for query command"() {
    when:
    HbcsUtils.processQueryCommandArgs(args)

    then:
    thrown(resultException)

    where:
    args             || resultException
    null             || IllegalArgumentException
    '1'.split(',')   || IllegalArgumentException
    '1,2'.split(',') || IllegalArgumentException
  }

  def makePath(fileName) {
    System.getProperty("java.io.tmpdir") + File.separator + fileName
  }
}
