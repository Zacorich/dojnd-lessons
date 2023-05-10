package advanced_java_programming_techniques.functional_programming;

public class BinaryOperationMain {
    public static void main(String[] args) {
        BinaryOperation add = (a, b) -> a + b;
        assert 5 == add.apply(3,2);
    }
}
