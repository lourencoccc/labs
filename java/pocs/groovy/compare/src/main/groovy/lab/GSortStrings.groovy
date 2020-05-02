package lab
/**
 * Created by joao on 11/02/15.
 */
class GSortStrings {

    static void main(String [] args){
        def strings =  ["Está","é","uma","lista"]
        strings << "de"
        strings << "palavras"

        //Ordernação alfabetica
        strings.sort()
        println "Alfa. $strings"

        //Ordenação crescente pelo tamannho da string
        strings.sort { it.length() }
        println "Cres. $strings"

        //Ordenação decrescente pelo tamannho da string
        strings.sort { -it.size() }
        println "Desc. $strings"
    }

}
