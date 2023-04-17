package java_fundamentals.advanced_collections;

import java.util.*;

public class SetsExercise {

    public static void createASetFromTheList(){
        List<String> numbers = new ArrayList<String>();
        Collections.addAll(numbers, "1", "2", "2", "3", "3", "4", "5");
        Set<String> uniqueNumbers = new HashSet<String>(numbers);
        for(String number : uniqueNumbers){
            System.out.println(number);
        }

    }
}
