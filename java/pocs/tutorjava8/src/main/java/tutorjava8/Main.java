package tutorjava8;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Main {

    public static void main(String [] args) {
         // System.out.println("Hello Java8");

        // List<String> names = Arrays.asList("12", "244", "344444:");
        // Stream lengths = names.stream().map(name -> name.length());
        // Integer maxLen = names.stream().map(name -> name.length()).reduce(0, (a, b) -> a > b ? a : b);
        // lengths.forEach(System.out::println);

        // System.out.printf("Max len is %d", maxLen);

        LocalDateTime date = LocalDateTime.now()
            .withHour(0).withMinute(0).withSecond(0).withNano(0);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(DateTimeFormatter.ISO_DATE);
        System.out.printf("Data ISO %s \n", text);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt.format(DateTimeFormatter.ISO_INSTANT));

    }


}
