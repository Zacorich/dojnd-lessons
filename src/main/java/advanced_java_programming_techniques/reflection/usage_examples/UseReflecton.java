package advanced_java_programming_techniques.reflection.usage_examples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UseReflecton {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Class<String> c = (Class<String>) "Hello world!".getClass();
        Class<String> c1 = String.class;
        Class<int[]>  c2 = int[].class;
        Class<String> c3 = (Class<String>) Class.forName("java.lang.String");
        Class c4 = byte.class;

        Method m = "Atticus".getClass().getMethod("toLowerCase");
        System.out.println(m.invoke("Finch"));

        //The following example references Erasure of Generic Types topic of java docs -
        //https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html
        //Since String implements Comparable<String> and Comparable<T> defines method compareTo(T o)
        //and String class implements it as compareTo(String o); as signature compareTo(T o) is different from
        //compareTo(String o) a synthetic method 'public synthetic bridge int compareTo(Object o){return compareTo((String) o);}
        //is generated to be able to call both methods on the class
        //https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html

        //call synthetic method
        m = String.class.getMethod("compareTo", Object.class);
        System.out.println(m.invoke("A", "B"));
        //call String's implementation of the method
        m = String.class.getMethod("compareTo", String.class);
        System.out.println(m.invoke("A", "B"));

        //the following method will throw NoSuchMethodException because none of the extended classes and String defines
        //compareTo() method with no parameters
        m = String.class.getMethod("compareTo");

        //also because of the Erasure of Generic Types, the following code cannot be compiled:
        //Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
//        public class Example {
//            public void print(Set<String> strSet) { }
//            public void print(Set<Integer> intSet) { }
//        }
        //after erasure the following will be in RUNTIME which contains two methods with the same signature
//        public class Example {
//            public void print(Set strSet) { }
//            public void print(Set intSet) { }
//        }

        //Type Erasure examples of bounded and unbounded type parameter
        //https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html
        //Node<T> -> Node class definition plus all T generics in the class are replaced with Object
        //Node<T extends Comparable<T>> -> Node class definition plus all T generics in the class replaced with Comparable
        //Note<T extends Comparable<T extends String>> -> unexpected bounding

    }
}
