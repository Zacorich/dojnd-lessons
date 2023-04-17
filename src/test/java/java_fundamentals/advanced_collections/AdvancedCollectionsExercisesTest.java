package java_fundamentals.advanced_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdvancedCollectionsExercisesTest {

    @Test
    void mapExerciseTest() {
        Assertions.assertEquals("Mike", MapExercise.simpleHashMap().getFirstName());

        MapExercise.hashMapExercise();
    }

    @Test
    void setExerciseTest(){
        SetsExercise.createASetFromTheList();
    }
}