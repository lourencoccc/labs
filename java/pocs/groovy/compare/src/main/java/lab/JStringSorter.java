package lab;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ordenador de Strings Java
 * @author joao
 */
public class JStringSorter {

    public List<String> sortAlpha(List<String> strings) {
        Collections.sort(strings);
        return strings;
    }

    public List<String> sortByDescLength(List<String> strings) {
        Collections.sort(strings, new Comparator<String>() { //Inner Class
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return strings;
    }

    public List<String> sortByAscLength(List<String> strings) {
        Collections.sort(strings, new Comparator<String>() { //Inner Class
            public int compare(String s1, String s2) {
                return  s1.length() - s2.length();
            }
        });
        return strings;
    }
}
