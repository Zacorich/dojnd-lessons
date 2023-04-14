package java_fundamentals.oop.polymorphism;

public class Boat extends Vehicle{
    public Boat(String start, String stop, String speed, String direction) {
        super(start, stop, speed, direction);
    }

    public Boat(){
        super("Boat start", "Boat stop", "Boat speed", "Boat direction");   
    }

    @Override
    public void speed() {
        super.speed();
        System.out.println("\tSome additional boat speed features");
    }
}
