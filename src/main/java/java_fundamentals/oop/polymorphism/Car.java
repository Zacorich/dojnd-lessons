package java_fundamentals.oop.polymorphism;

public class Car extends Vehicle{
    public Car(String start, String stop, String speed, String direction) {
        super(start, stop, speed, direction);
    }

    public Car(){
        super("Car start", "Car stop", "Car speed", "Car direction");
    }
}
