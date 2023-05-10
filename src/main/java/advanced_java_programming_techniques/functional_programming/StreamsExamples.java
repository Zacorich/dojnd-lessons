package advanced_java_programming_techniques.functional_programming;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {
    public static void main(String[] args) {
        System.out.println(Stream.of("hello", "world", "and")
                .map(String::toUpperCase)
                .collect(Collectors.joining(" ", ">", "!")));

        //will print nothing as stream are lazy processed until terminal operation is executed
        Stream.of(1, 2, 3)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::print);

        //collector is a most used terminal stream operation in Streams API
        //Collectors class contains a number of predefined collectors for various tasks
        //so for upper unterminated stream example to print intermediate operation I need to define terminal stream
        //operation
        System.out.println(Stream.of(1, 2, 3)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::print).collect(Collectors.toList()));

    }
}
