package intro_to_java.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    @Test
    void setOfTests() {
        Assertions.assertTrue(Arrays.pressConference());

        double[] temperatures = {5, 5, 4, 6, 7, 3};
        Assertions.assertEquals(5, Arrays.calculateAverage(temperatures));

        double[] speeds = {7.85, 7.32, 4.9, 6.22, 5.4, 7.3, 5.19};
        Assertions.assertEquals(4.9, Arrays.rubiksChampion(speeds, false));
        Assertions.assertEquals(7.85, Arrays.rubiksChampion(speeds, true));


        String[] names = {"Jack", "Same", "John", "Reece", "Constantin", "Eva", "Kate"};
        Assertions.assertEquals("Constantin", Arrays.findLongestName(names));

        double[][] grades = {{1.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0}};
        Assertions.assertEquals(16, Arrays.nestedLoopIterationForTwoDimensionalArray(grades));


    }
}