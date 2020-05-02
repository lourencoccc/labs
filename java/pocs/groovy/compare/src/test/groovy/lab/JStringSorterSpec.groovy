package lab

import spock.lang.Specification
/**
 * Created by joao on 11/02/15.
 */
class JStringSorterSpec extends Specification {

    def "deve ordenar strings em ordem alfabetica"(){
        given:
        def sorter = new JStringSorter()

        when:
        def palavrasOrdenadas = sorter.sortAlpha(palavras)

        then:
        palavrasOrdenadas == palavrasEsperadas

        where:
        palavras      || palavrasEsperadas
        ['b','a','c'] || ['a','b','c']
        ['h','g','f'] || ['f','g','h']
    }

    def "deve ordenar strings em ordem crescente do tamnho da string"(){
        given:
        def sorter = new JStringSorter()

        expect:
        sorter.sortByAscLength(palavras) == palavras_esperadas

        where:
        palavras         || palavras_esperadas
        ['b','a','c']    || ['b','a','c']
        ['ba','a','ccc'] || ['a','ba','ccc']
    }

    def "deve ordenar strings em ordem decrescente do tamnho da string"(){
        expect:
        new JStringSorter().sortByDescLength(palavras) == palavras_esperadas

        where:
        palavras         || palavras_esperadas
        ['b','a','c']    || ['b','a','c']
        ['ba','a','ccc'] || ['ccc','ba','a']
    }



}
