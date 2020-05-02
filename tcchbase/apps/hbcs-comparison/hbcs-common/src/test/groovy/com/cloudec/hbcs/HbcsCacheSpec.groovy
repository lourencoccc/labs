package com.cloudec.hbcs

import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-02-24
 */
class HbcsCacheSpec extends Specification {

  def hbcsCache

  def setup() {
    hbcsCache = new HbcsCache('hbcscachespec')
  }

  def cleanup() {
    hbcsCache.destroy()
  }

  def "should save data and get values"() {
    given:
    def data = [
        'id'   : '1',
        'name' : 'Joao',
        'email': 'joao@mail.com'
    ]
    def hbcsCache = new HbcsCache('hbcscachespec')

    when:
    hbcsCache.put(data.id, data)
    def dataResult = hbcsCache.get('1');

    then:
    dataResult.id == '1'
    and:
    dataResult.name == 'Joao'
    and:
    dataResult.email == 'joao@mail.com'
  }
}
