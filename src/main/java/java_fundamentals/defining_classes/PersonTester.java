package java_fundamentals.defining_classes;

public class PersonTester {
    public static void main(String[] args) {
        Person bob = new Person("Bob", "Phillips");
        Person mike = new Person("Mike", "Lipson");
        System.out.println(bob.toString());
        System.out.println(mike.toString());

        //don't need explicitly call toString() method on objects as println does that for us
        System.out.println(bob);
        System.out.println(mike);
    }
}
