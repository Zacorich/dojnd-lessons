package advanced_java_programming_techniques.functional_programming.calculator;
import advanced_java_programming_techniques.reflection.unittest_framework.Test;
import advanced_java_programming_techniques.reflection.unittest_framework.UnitTest;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
public class TestRunner {
    private static final List<Class<?>> TESTS = List.of(CalculatorTest.class);

    public static void main(String[] args) throws Exception {

        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        for (Class<?> klass : TESTS) {
            // TODO: For each test class "klass", do the following:
            //        1. Ensure the class implements the UnitTest interface.
            if(!(UnitTest.class.isAssignableFrom(klass))){
                failed.add(klass.getName() + " class must implement UnitTest class");
                continue;
            }
            //        2. Create an instance of the class and cast it to UnitTest.
            UnitTest currentUnitTest = (UnitTest)klass.getConstructor().newInstance();

            // TODO: For each method that is annotated with @Test:
            for(Method method : currentUnitTest.getClass().getMethods()) {
                //        1. Call beforeEachTest()
                currentUnitTest.beforeEachTest();
                if(method.getAnnotation(Test.class) != null) {
                    //        2. Invoke the method annotated with @Test
                    try {
                        method.invoke(currentUnitTest);
                        //        3. Call afterEachTest()
                        currentUnitTest.afterEachTest();
                        //        4. Record the test results by adding getTestName(...) to either the "passed" list
                        //           of the "failed" list.
                        passed.add(method.getName());
                    } catch (AssertionError ae){
                        failed.add(getTestName(klass, method));
                    }
                }
            }
        }

        System.out.println("Passed tests: " + passed);
        System.out.println("FAILED tests: " + failed);
    }

    private static String getTestName(Class<?> klass, Method method) {
        return klass.getName() + "#" + method.getName();
    }
}
