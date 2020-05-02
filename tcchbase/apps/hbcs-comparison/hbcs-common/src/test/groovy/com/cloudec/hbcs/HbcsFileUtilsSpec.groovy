package com.cloudec.hbcs

import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
class HbcsFileUtilsSpec extends Specification {

  def tmpFileName = 'hbcstest.txt'
  def tmpDir = 'hbcstest'
  def tmpSubDir1 = 'hbcstestSub1'
  def tmpSubDir2 = "hbcstestSub2"

  def setup() {
    def file = new File(makePath(tmpFileName))
    file.write 'hbcs test file.'
    def fileDir = new File(makePath(tmpDir))
    fileDir.mkdir()
    new File(makePath("$tmpDir${File.separator}$tmpSubDir1")).mkdir()
    new File(makePath("$tmpDir${File.separator}$tmpSubDir2")).mkdir()
  }

  def cleanup() {
    new File(makePath(tmpFileName)).delete()
    new File(makePath(tmpDir)).deleteDir()
  }

  def "should throw HbcsException when verify if file exist"() {
    when:
    HbcsFileUtils.verifyIfExist(makePath('hbcsa.txt'))

    then:
    def e = thrown(HbcsException)
    and:
    e.message == 'file_not_exist: hbcsa.txt'
  }

  def "should return true when verify if file exist"() {
    expect:
    HbcsFileUtils.verifyIfExist(makePath(tmpFileName)) == true
  }

  def "should return file name"() {
    expect:
    HbcsFileUtils.getFileName(makePath(tmpDir)) == tmpDir
  }

  def makePath(fileName) {
    System.getProperty("java.io.tmpdir") + File.separator + fileName
  }

  def "should return list folders"() {
    when:
    List<File> datasetPaths = HbcsFileUtils.listSubDirs(makePath(tmpDir))

    then:
    datasetPaths.contains(new File(makePath("$tmpDir${File.separator}$tmpSubDir1")))
    and:
    datasetPaths.contains(new File(makePath("$tmpDir${File.separator}$tmpSubDir2")))
  }


}
