package lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ordenar Strings
 * @author joao
 */
public class JSortStrings {

    public static void main(String [] args){
        List<String> strings = new ArrayList<String>();
        strings.add("Está");
        strings.add("é");
        strings.add("uma");
        strings.add("lista");
        strings.add("de");
        strings.add("palavras");

        //Ordernação Lexical
        Collections.sort(strings);

        System.out.println(strings);
    }
}
