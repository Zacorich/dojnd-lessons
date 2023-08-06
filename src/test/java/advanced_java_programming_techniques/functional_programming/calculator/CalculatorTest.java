package advanced_java_programming_techniques.functional_programming.calculator;

import advanced_java_programming_techniques.reflection.unittest_framework.Test;
import advanced_java_programming_techniques.reflection.unittest_framework.UnitTest;

public final class CalculatorTest implements UnitTest {


    private final Calculator calculator = new Calculator();

    @Override
    public void beforeEachTest() {
        calculator.registerOperation("+", (a, b) -> a + b);
        calculator.registerOperation("-", (a, b) -> a - b);
        calculator.registerOperation("/", (a, b) -> a / b);
        calculator.registerOperation("*", (a, b) -> a * b);
    }

    @Test
    public void testAddition() throws AssertionError{
        assert calculator.calculate(1, "+", 1) == 2;
        System.out.println("test passed");
    }

    @Test
    public void testSubtraction() throws AssertionError {
        assert calculator.calculate(45, "-", 43) == 1;
    }

    public void testNotActuallyATest(){
        assert 1 == 0;
    }
}