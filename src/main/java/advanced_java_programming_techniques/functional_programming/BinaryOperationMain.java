package advanced_java_programming_techniques.functional_programming;

import java.util.function.BinaryOperator;

public class BinaryOperationMain {
    public static void main(String[] args) {
        BinaryOperation add = (a, b) -> a + b;
        assert 5 == add.apply(3,2);

        //using build int BinaryOperator
        BinaryOperator<Integer> add2 = (a, b) -> a + b;
        System.out.println(add2.apply(10, 10));
    }
}
