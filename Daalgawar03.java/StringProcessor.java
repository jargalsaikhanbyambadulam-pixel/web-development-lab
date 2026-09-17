\import java.util.*;
import java.util.function.*;

public class StringProcessor {

    public static void processStrings(List<String> list,
                                      Predicate<String> predicate,
                                      Function<String, String> function,
                                      Consumer<String> consumer) {

        for (String s : list) {
            if (predicate.test(s)) {
                String result = function.apply(s);
                consumer.accept(result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "lambdamethod", "oop", "programming");

        Predicate<String> predicate = s -> s.length() > 5;

        Function<String, String> function = s -> new StringBuilder(s).reverse().toString();

        Consumer<String> consumer = s -> System.out.println("GARSHIL: " + s.toUpperCase());

        processStrings(words, predicate, function, consumer);
    }
}