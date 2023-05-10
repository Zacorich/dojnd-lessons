package advanced_java_programming_techniques.functional_programming;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class ReadFilesWithLambdaExceptionsMain {
    public static void main(String[] args) throws IOException {
        //Stream.of(...) returns a stream of strings (Stream<String>).
        Stream.of("build/resources/main/file-a.txt",
                        "build/resources/main/file-b.txt",
                        "build/resources/main/file-c.txt")
                //.map(Path::of) converts the Stream<String> to a Stream<Path> objects (each string is passed to
                // the Path#of) method
                .map(Path::of)
                //.map(p -> { ... }) converts the Stream<Path>s to a Stream<List<String>>. Any IOExceptions are
                // quietly ignored by returning an empty list.
                .map(p -> {
                    try {
                        return Files.readAllLines(p, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        return List.of();
                    }
                })
                //.flatMap(Collection::stream) "flattens" the Stream<List<String>> into a Stream<String> (the Collection#stream
                // method converts each List<String> to a Stream<String>, so each list element becomes a top-level element
                // in the stream returned by flatMap().
                .flatMap(List::stream)
                //Finally, .forEach(System.out::println) prints each of the strings to standard output.
                .forEach(System.out::println);
    }
}
