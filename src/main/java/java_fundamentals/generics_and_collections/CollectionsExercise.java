package java_fundamentals.generics_and_collections;

import java.util.LinkedList;
import java.util.List;

public class CollectionsExercise {
    public static void main(String[] args) {
        List<String> listOfItems = new LinkedList<String>();
        listOfItems.add("Mike");
        listOfItems.add("Bob");
        listOfItems.add("Alice");
        for (String item : listOfItems) {
            System.out.println(item);
        }
    }
}
