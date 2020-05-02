package com.cloudec.hbcs

import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
class HbcsExceptionSpec extends Specification {

  def "should crete runtime exception without message"() {
    when:
    throw new HbcsException()

    then:
    def e = thrown(HbcsException)
    e.message == null
    and:
    e.cause == null
  }

  def "should crete runtime exception with message"() {
    setup:
    def message = 'erros na carga'
    when:
    throw new HbcsException(message)

    then:
    def e = thrown(HbcsException)
    e.message == message
    and:
    e.cause == null
  }

  def "should crete runtime exception with message and couse"() {
    setup:
    def message = 'erros na carga'
    when:
    throw new HbcsException(message, new IOException())

    then:
    def e = thrown(HbcsException)
    e.message == message
    and:
    e.cause.class == IOException
  }

}
