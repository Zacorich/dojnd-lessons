package advanced_java_programming_techniques.functional_programming.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculator {

    Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
    public void registerOperation(String s, BinaryOperator<Integer> operationLambda) {
        operations.put(s.strip(), operationLambda);
    }

    public Integer calculate(int a, String operator, int b) {
        if(operations.containsKey(operator)) {
            return operations.get(operator).apply(a, b);
        }
        return -1;
    }
}
