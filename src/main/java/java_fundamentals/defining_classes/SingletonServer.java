package java_fundamentals.defining_classes;

import java.util.ArrayList;

public class SingletonServer {
    //use volatile jave keyword for thread safety - https://stackoverflow.com/a/11640026/4592525
    private static volatile SingletonServer instance = new SingletonServer();
    private ArrayList hotelRoomsAsSomeSharedObjectBetweenClasses;
    private SingletonServer(){
        //initialise shared object
        hotelRoomsAsSomeSharedObjectBetweenClasses = new ArrayList();
    }

    public static SingletonServer getInstance(){
        return instance;
    }

    public ArrayList getHotelRooms() {
        return hotelRoomsAsSomeSharedObjectBetweenClasses;
    }
}
