package java_fundamentals.defining_classes;

import java.util.ArrayList;

public class SingletonServer {
    //here is a better alternative of Singleton creation -https://www.digitalocean.com/community/tutorials/thread-safety-in-java-singleton-classes
    //to achieve following features:
    //1. Thread safety is guaranteed
    //2. Client application can pass arguments
    //3. Lazy initialization achieved
    //4. Synchronization overhead is minimal and applicable only for first few threads when the variable is null.

    //use volatile jave keyword for thread safety - https://stackoverflow.com/a/11640026/4592525
    //this is a generic singleton and it is not thread safe
    private static volatile SingletonServer instance = new SingletonServer();
    private ArrayList hotelRoomsAsSomeSharedObjectBetweenClasses;

    private SingletonServer() {
        //initialise shared object
        hotelRoomsAsSomeSharedObjectBetweenClasses = new ArrayList();
    }

    public static SingletonServer getInstance() {
        return instance;
    }

    public ArrayList getHotelRooms() {
        return hotelRoomsAsSomeSharedObjectBetweenClasses;
    }
}
