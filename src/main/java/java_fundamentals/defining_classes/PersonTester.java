package java_fundamentals.defining_classes;

public class PersonTester {
    public static void main(String[] args) {
        Person bob = new Person("Bob", "Phillips");
        Person mike = new Person("Mike", "Lipson");
        System.out.println(bob.toString());
        System.out.println(mike.toString());
    }
}
