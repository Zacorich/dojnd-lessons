package intro_to_java.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemSet4Test {

    @Test
    void testsSet() {
        Assertions.assertEquals(80, ProblemSet4.question1());

        Assertions.assertEquals(120, ProblemSet4.question2(5, false));
        Assertions.assertEquals(120, ProblemSet4.question2(5, true));

        //question 3
        String[] sentence = {"Learning", "Java", "is", "fun."};
        Assertions.assertEquals(1, ProblemSet4.indexOfFirstOccurrence(sentence, "Java"));

        //question 4
        Assertions.assertEquals(48, ProblemSet4.yearsTilOneMillion(100000) );

        //question 5
        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        ProblemSet4.printInReverse(daysOfTheWeek);

        //question 6
        int [] values = {1, 0, 2, 3, -1, 2};
        Assertions.assertEquals(4, ProblemSet4.findRange(values));

        //question 7
        Assertions.assertEquals("#\n##\n###\n", ProblemSet4.question7());

        //question 8
        ProblemSet4.monopolyRollRecursive(0, 0);
        ProblemSet4.monopolyRoll();

    }

}