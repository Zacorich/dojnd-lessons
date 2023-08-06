package advanced_java_programming_techniques.reflection.custom_classloader;

import advanced_java_programming_techniques.reflection.custom_classloader.tests.CalculatorTest;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class TestRunner {
    public static void main(String[] args) throws Exception {
        // TODO: Make sure the user has passed in two arguments: one for the test directory, and one
        //       with the name of the test class to run.
        if(args.length < 2){
            System.out.println("Two arguments needed:");
            System.out.println("1 - external test directory path");
            System.out.println("2 - the name of the class in that directory to run");
            return;
        }
        URL classesPath = Path.of(args[0]).toUri().toURL();
        URL[] classesPaths = new URL[]{classesPath};
        String testClassName = args[1];
        URLClassLoader classLoader = new URLClassLoader(classesPaths);

        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        // TODO: Rewrite this for-loop. Instead of using the TESTS list (which you should have deleted),
        //       locate the test using the command-line arguments and a custom ClassLoader. Then call
        //       Class.forName(className, true, loader) using the custom ClassLoader for the third
        //       parameter.
        //
        //       The code to record passed/failed tests should pretty much stay the same.
        Class<?> klass = Class.forName(testClassName, true, classLoader);
        if (!UnitTest.class.isAssignableFrom(klass)) {
            throw new IllegalArgumentException("Class " + klass.toString() + " must implement UnitTest");
        }

        for (Method method : klass.getDeclaredMethods()) {
            if (method.getAnnotation(Test.class) != null) {
                try {
                    UnitTest test = (UnitTest) klass.getConstructor().newInstance();
                    test.beforeEachTest();
                    method.invoke(test);
                    test.afterEachTest();
                    passed.add(getTestName(klass, method));
                } catch (Throwable throwable) {
                    failed.add(getTestName(klass, method));
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
