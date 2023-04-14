package java_fundamentals.oop.inheritance;

public class PersonTester {
    public static void main(String[] args) {
        Person sally =  new Person("Sally", "Phillips");
        System.out.println(sally);
        Student mike = new Student("Mike", "Thompson", "12345");
        System.out.println(mike);
        StudentEmployee jeff = new StudentEmployee("Jeff", "Sam", 20.5, "#4567", "12346");
        System.out.println(jeff);
    }
}
