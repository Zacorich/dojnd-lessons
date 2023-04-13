package intro_to_java.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YahtzeeTest {

    @Test
    void fiveDices() {
        Assertions.assertTrue(0 <= Yahtzee.fiveDices());
    }

    @Test
    void getYahtzee() {
        Assertions.assertTrue(0 <= Yahtzee.getYahtzee(5, 6));
        Assertions.assertTrue(500 <= Yahtzee.getYahtzee(6, 6));
        Assertions.assertTrue(1000 <= Yahtzee.getYahtzee(7, 7));
        Assertions.assertTrue(4000 <= Yahtzee.getYahtzee(10, 6));
    }

    @Test
    void factorial() {
        //2*1 = 2;
        Assertions.assertEquals(2, Yahtzee.factorial(2));
        //1
        Assertions.assertEquals(1, Yahtzee.factorial(1));
        //5*4*3*2*1 = 120;
        Assertions.assertEquals(121, Yahtzee.factorial(5));
    }
}