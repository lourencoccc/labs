package lab

/**
 * Ordenador de Strings Groovy
 * @author joao
 */
class GStringSorter {

    List<String> sortAlpha(List<String> strings) {
        strings.sort()
    }

    List<String> sortByDescLength(List<String> strings) {
        strings.sort { -it.length() }
    }

    List<String> sortByAscLength(List<String> strings) {
        strings.sort { it.length() }
    }
}
