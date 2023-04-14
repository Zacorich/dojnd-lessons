package java_fundamentals.oop.abstract_classes;

public abstract class Vehicle {
    protected String start;
    protected String stop;
    protected String direction;

    public Vehicle(String start, String stop, String direction) {

        this.start = start;
        this.stop = stop;
        this.direction = direction;
    }
    //force every subclass to implement specific method
    public abstract void speed();
}
