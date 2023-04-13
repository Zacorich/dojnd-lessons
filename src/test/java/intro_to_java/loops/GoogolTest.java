package intro_to_java.loops;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GoogolTest {

    @Test
    void getGoogol() {
        Assertions.assertEquals(101, Googol.getGoogol().length());
    }
}