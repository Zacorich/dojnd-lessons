package java_fundamentals.generics_and_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExercise {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Bob");
        names.add("Alice");
        Iterator iterator = names.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
