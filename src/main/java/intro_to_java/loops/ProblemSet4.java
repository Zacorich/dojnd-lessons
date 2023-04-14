package intro_to_java.loops;

import intro_to_java.Utils;

public class ProblemSet4 {
    public static int question1() {
        int n = 10;
        while (n < 50) {
            n = n * 2; // 1 - 20(10*2), 2 - 40(20*2), 3 - 80(40*2)
        }
        System.out.println(n);//80
        return n;
    }

    public static int question2(int valueToGetFactorialFor, boolean useRecursion) {
        //using reucrsion

        int result = valueToGetFactorialFor;
        if (useRecursion) {
            result = (int) Utils.factorial(valueToGetFactorialFor);
        } else {
            for (int i = valueToGetFactorialFor - 1; i > 0; i--) {
                result *= i;
            }
        }

        return result;
    }

    /**
     * Complete the code in this function to find and return the lowest index in the String array
     * stringArray that the String target occurs. If the String target does not occur in
     * stringArray, -1 should be returned.
     * As an example of how this function should work, this code should print 1, because the word
     * "Java" appears at index 1.
     * String[] sentence = {"Learning", "Java", "is", "fun."};
     * int indexOfWordJava = indexOfFirstOccurrence(sentence, "Java");
     * System.out.println(indexOfWordJava);
     * Hint: you cannot compare two Strings using the == operator! This will be false unless
     * the two Strings are actually the same String object, not just two Strings with the same
     * letters. To check whether two Strings have the same letters, use the equals() method:
     * if (myString1.equals(myString2)).
     */
    public static int indexOfFirstOccurrence(String[] stringArray, String target) {
        int foundIndex = -1;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(target)) {
                foundIndex = i;
            }
        }
        return foundIndex;
    }


    /**
     * A savings account yields 5% interest annually. This Java function is designed to determine
     * how many years it will take for you to have $1,000,000 on deposit given an initial value. The
     * parameter represents the initial deposit, and the function should return an integer number
     * of years before there will be $1,000,000 or more in the account. Write a loop to determine
     * the number of years, and return that value.
     * (Hint: Do we know how many times this loop needs to iterate? Does this mean a for loop
     * or a while loop is more appropriate?)
     * Starting code:
     * public int yearsTilOneMillion(double initialBalance) {
     * return 0;
     * }
     */
    public static int yearsTilOneMillion(double initialBalance) {
        int numberOfYears = 0;
        double balance = initialBalance;
        while (balance < 1000000) {
            balance += balance * 0.05;
            numberOfYears++;
        }
        return numberOfYears;
    }

    /**
     * Complete the Java function below to print out all the Strings in the String array parameter
     * in reverse order. (The String at the highest index should be printed first, then the String at
     * the next highest index, and so on. The String at index 0 should be printed last.)
     * For example, if a String array called weekdays had value
     * {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}
     * then this function call:
     * printInVerverse(weekdays);
     * would print:
     * Friday
     * Thursday
     * Wednesday
     * Tuesday
     * Monday
     * Starting code:
     * public void printInReverse(String[] stringArray) {
     * }
     */
    public static void printInReverse(String[] stringArray) {
        //decrementing
        for (int i = stringArray.length - 1; i >= 0; i--) {
            System.out.println(stringArray[i]);
        }
        //incrementing
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[stringArray.length - 1 - i]);
        }
    }

    /**
     * Complete the function below, which finds the range covered by an integer array. Inside
     * the function, find the smallest value in the parameter array, and find the largest value, and
     * return the largest value minus the smallest value. If the array has length 0, return -1.
     * For example, if the variable myIntArray had the value
     * {1, 0, 2, 3, -1, 2}
     * then the function call
     * findRange(myIntArray)
     * would return 4. The largest value in the array is 3, the smallest value is -1, and 3−(−1) = 4.
     * Starting code:
     * public int findRange(int[] intArray) {
     * return -1;
     * }
     */
    public static int findRange(int[] intArray) {
        if (intArray.length > 0) {
            int min = intArray[0];
            int max = intArray[0];
            for (int i = 1; i < intArray.length; i++) {
                if (min > intArray[i]) {
                    min = intArray[i];
                }
                if (max < intArray[i]) {
                    max = intArray[i];
                }
            }
            return max - min;
        }
        return -1;
    }

    public static String question7() {
        int rows = 3;
        String result = "";
        for (int i = 1; i <= rows; i++) {
            String thisRow = "";
            for (int j = 0; j < i; j++) {
                thisRow = thisRow + "#";
            }
            result += thisRow + "\n";//simulate println()
        }
        return result;
    }

    /**
     * Let’s improve the monopolyRoll() function from the previous problem set. Recall that in
     * Monopoly, players roll two six-sided dice to determine their move. If the same value is on
     * both dice, this is called "rolling doubles," and it means they go again. In the last problem
     * set, you wrote a function that rolled two six-sided dice and, if the values on both die were
     * the same, rolled two more and returned the sum. This time, write a function that does the
     * same except it continues rolling until two non-equal values appear on the two dice. In other
     * words, the function should behave as follows:
     * 1. Generate two random numbers in the 1 to 6 range.
     * 2. If they are not the same, return the sum of all numbers rolled so far.
     * 3. If they are the same, keep track of the total rolled so far and return to step 1.
     * Think about what kind of loop you want to define to repeat these steps. Again, you may
     * want to define a separate function for generating dice rolls.
     * Optional challenge: in Monopoly, if a player rolls doubles three times in a row, they go
     * to “jail." Modify your function to keep track of the number of rolls made so far. If three
     * consecutive doubles are rolled, return -1 instead of continuing to roll.
     * Optional challenge 2: in the last lesson, you learned about while loops and for loops as a
     * way to make a computer program repeat. There is another method for making a program
     * repeat using only functions called recursion. A "recursive" function is one which calls itself
     * inside itself. See if you can write the monopolyRoll() function by calling monopolyRoll()
     * inside the function itself to handle the case where further rolls are made.
     * You can get an overview of recursion in Java here:
     * https://howtoprogramwithjava.com/java-recursion/
     */
    public static int monopolyRollRecursive(int totalSum, int totalDoubleRolls) {
        //roll two dices with 6 sides each
        int rollDice1 = Utils.rollDiceWithSides(6);
        int rollDice2 = Utils.rollDiceWithSides(6);

        //first recursion exit condition
        if (rollDice1 != rollDice2) {
            System.out.println("Not same: " + +rollDice1 + ", " + rollDice2);
            return totalSum + rollDice2 + rollDice1;
        }

        //second recursion exit condition
        System.out.println("'Rolling doubles': " + rollDice1 + ", " + rollDice2);
        totalDoubleRolls++;
        totalSum += (rollDice2 + rollDice1);
        if (totalDoubleRolls == 3) {
            System.out.println("You are going to jail because of 3 consecutive 'rolling doubles'");
            return -1;
        }

        //recursive call
        return monopolyRollRecursive(totalSum, totalDoubleRolls);
    }

    //non-recursive approach for monopolyRoll()
    public static int monopolyRoll() {
        int totalSum = 0;
        int totalDoubleRolls = 0;

        int rollDice1 = Utils.rollDiceWithSides(6);
        int rollDice2 = Utils.rollDiceWithSides(6);

        while (rollDice1 == rollDice2) {
            System.out.println("'Rolling doubles': " + rollDice1 + ", " + rollDice2);
            totalDoubleRolls++;
            totalSum += (rollDice2 + rollDice1);
            if (totalDoubleRolls == 3) {
                System.out.println("You are going to jail because of 3 consecutive 'rolling doubles'");
                return -1;
            }

            //roll dices again
            rollDice1 = Utils.rollDiceWithSides(6);
            rollDice2 = Utils.rollDiceWithSides(6);
        }

        System.out.println("Not same: " + +rollDice1 + ", " + rollDice2);
        return totalSum + rollDice2 + rollDice1;
    }
}
