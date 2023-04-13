package intro_to_java.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PyramidsTest {

    @Test
    void countPyramidBlocks() {
        Assertions.assertEquals(9+4+1, Pyramids.countPyramidBlocks(3));
    }

}