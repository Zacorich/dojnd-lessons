package java_fundamentals.advanced_collections;

import java_fundamentals.oop.inheritance.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static Person simpleHashMap() {
        Map<String, Person> mapOfPeople = new HashMap<String, Person>();
        Person mike = new Person("Mike", "", "mike@email.com");
        Person shaun = new Person("Shaun", "", "shaun@email.com");
        Person sally = new Person("Sally", "", "sally@email.com");
        Person cesar = new Person("Cesar", "", "cesar@email.com");

        mapOfPeople.put(mike.getEmail(), mike);
        mapOfPeople.put(shaun.getEmail(), shaun);
        mapOfPeople.put(sally.getEmail(), sally);
        mapOfPeople.put(cesar.getEmail(), cesar);

        //iterate over keys
        for(String email : mapOfPeople.keySet()){
            System.out.println(email);
        }

        //iterate over values
        for(Person person : mapOfPeople.values()){
            System.out.println(person.getFirstName());
        }

        //iterate over key-value mappings
        for(Map.Entry<String, Person> keyValueMapping: mapOfPeople.entrySet()){
            System.out.println(keyValueMapping);
        }

        return mapOfPeople.get("mike@email.com");
    }
}
