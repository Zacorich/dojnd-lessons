package intro_to_java.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopsIterationsTest {

    @Test
    void addNumbers() {
        Assertions.assertEquals(105, LoopsIterations.addNumbers());
    }

    @Test
    void stepFaster() {
        Assertions.assertTrue(LoopsIterations.stepFaster(-100, 100));
        Assertions.assertTrue(!LoopsIterations.stepFaster(-101, 100));
        Assertions.assertTrue(!LoopsIterations.stepFaster(-101, 101));
        Assertions.assertTrue(!LoopsIterations.stepFaster(-100, 101));
    }

    @Test
    void searchWifi() {
        Assertions.assertTrue(LoopsIterations.searchWifi());
    }

    @Test
    void rollASix() {
        Assertions.assertTrue(LoopsIterations.rollASix());
    }
}