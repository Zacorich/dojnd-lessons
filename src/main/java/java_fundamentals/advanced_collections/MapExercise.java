package java_fundamentals.advanced_collections;

import java_fundamentals.oop.inheritance.Person;

import java.lang.reflect.Array;
import java.util.*;

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

        printMapContents(mapOfPeople);

        return mapOfPeople.get("mike@email.com");
    }

    public static void printMapContents(Map<String, Person> mapOfPeople){
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
    }

    public static void hashMapExercise(){

        //create people list
        ArrayList<Person> people = new ArrayList<Person>();
        Person mike = new Person("Mike", "", "mike@gmail.com");
        Person shaun = new Person("Shaun", "", "shaun@gmail.com");
        Person sally = new Person("Sally", "", "sally@gmail.com");
        Person cesar = new Person("Cesar", "", "cesar@gmail.com");
        Collections.addAll(people, mike, shaun, sally, cesar);

        //create map out of people list
        Map<String, Person> mapOfPeople = new HashMap<String, Person>();
        for(Person person : people){
            mapOfPeople.put(person.getEmail(), person);
        }

        //print contents of the map
        printMapContents(mapOfPeople);

        //search person in the map
        System.out.println(mapOfPeople.get("mike@gmail.com"));
        System.out.println(mapOfPeople.get("jeff@gmail.com"));
        System.out.println(mapOfPeople.containsKey("mike@gmail.com"));
        System.out.println(mapOfPeople.containsKey("jeff@gmail.com"));
    }
}
