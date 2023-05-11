package advanced_java_programming_techniques.functional_programming;

import java.util.List;
import java.util.Objects;

public class OptionalExamples {
    public static void main(String[] args) {
        List<String> input = List.of("hello", "\t   ", "world", "", "\t", " ", "goodbye", "  ");
        System.out.println(input.stream().filter(Objects::nonNull).mapToInt(String::length).max().orElse(0));

        //what is good about Optional
        //1. it is a box around int, double etc. types and create a stream support inside
        //2. if value boxed by Optional is null I still can call .equals, .toString on the Optional object
        //3. .isEmpty and isPresent can be called on optional that signal the API caller to check value before using it
        //4. Methods like map or orElse can be used on both empty and non-empty Optional(s)
    }
}
