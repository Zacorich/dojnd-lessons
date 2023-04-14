package java_fundamentals.oop.polymorphism;

public class Plane extends Vehicle{
    public Plane(String start, String stop, String speed, String direction) {
        super(start, stop, speed, direction);
    }

    public Plane(){
        super("Plane start", "Plane stop", "Plane speed", "Plane direction");   
    }
}
