package advanced_java_programming_techniques.functional_programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public final class LambdaMain {
    public static long countMatchingStrings(List<String> input, Predicate<String> condition){
        return input.stream().filter(condition).count();
    }

    public static void main(String[] args) {
        //at least Java 9 needed ofr List.of(...)
        List<String> input = List.of("hello", "\t   ", "world", "", "\t", " ", "goodbye", "  ");

        //Java 1.7 way of overriding Predicate interface method
        //Note that instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
        //If an interface meets functional interface definition the interface will be considered functional without @FunctionalInterface annotation
        //All functional Interface must have at least one abstract method to be treated as functional interface override of Object class abstract
        // methods doesn't count as well as default methods of the interface as they provide implementations
        long numberOfWhitespacesStrings =
                countMatchingStrings(input,
                        new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.trim().isEmpty();
                            }
                        });
        System.out.println(numberOfWhitespacesStrings + " whitespaces strings(Override Predicate's test(...) method");
        //Java 1.8 way of using lambda expressions
        //(String s) - use parentheses to mark the parameter to the Lambda expression
        // '->' - use arrow syntax to mark the start of the body of the Lambda expression
        // {} - the body of the Lambda expression must return value
        numberOfWhitespacesStrings =
                countMatchingStrings(input,
                        (String s ) -> {
                    return s.trim().isEmpty();
                });
        System.out.println(numberOfWhitespacesStrings + " whitespaces strings(Lambda explicit)");
        //shortened way of writing same Lambda expression:
        //1. as the gbody of the Lambda expression contain a single statement and it is a return statement we can get
        // rid of the return keyword and curly braces
        //2. the Java compiler will infer the types of the parameters(which is String in this case) so we can get
        //rid of the marked parameter to the Lambda expression
        //3. As our Lambda has only one parameter we can get rid of the parentheses used to mark the parame
        // eventually we have simplified one line Lambda expression
        numberOfWhitespacesStrings = countMatchingStrings(input, s -> s.trim().isEmpty());

        System.out.println(numberOfWhitespacesStrings + " whitespaces strings(Lambda shortened)");

        //implementing an Interface method with a Lambda expression
        //Here we implement the abstract method 'R apply(T t, U u);' defined in BinaryOperator > BiFunction functional interface
        //extremely terse and handy way to implement functional interfaces
        BinaryOperator<Integer> add = (Integer a, Integer b) -> a+b;
        System.out.println(add.apply(1, 2));



    }
}
