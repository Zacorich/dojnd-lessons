package java_fundamentals.advanced_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapExerciseTest {

    @Test
    void mapExerciseTestsSet() {
        Assertions.assertEquals("Mike", MapExercise.simpleHashMap().getFirstName());
    }
}