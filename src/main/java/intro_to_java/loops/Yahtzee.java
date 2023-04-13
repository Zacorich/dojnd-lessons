package intro_to_java.loops;

public class Yahtzee {
    private static int rollDiceWithSides(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    private static int rollDice() {
        return rollDiceWithSides(6);
    }

    public static int fiveDices() {
        int dice1 = rollDice();
        int dice2 = rollDice();
        int dice3 = rollDice();
        int dice4 = rollDice();
        int dice5 = rollDice();
        int count = 1;
        while (!(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 && dice4 == dice5)) {
            //we need to re-roll
            dice1 = rollDice();
            dice2 = rollDice();
            dice3 = rollDice();
            dice4 = rollDice();
            dice5 = rollDice();
            count = count + 1;
        }
        System.out.println("Rolled 5 dices " + count + " times.");
        return count;
    }

    public static int getYahtzee(int numberOfDices, int numberOfSidesOnEachDice) {
        int[] dicesRoll = rollDices(numberOfDices, numberOfSidesOnEachDice);
        int count = 1;
        while (!integersInArrayAreEqual(dicesRoll)) {
            dicesRoll = rollDices(numberOfDices, numberOfSidesOnEachDice);
            count++;
        }
        double totalPosibleCombinations = factorial(numberOfDices * numberOfSidesOnEachDice);
                System.out.println("Rolled " + numberOfDices + " dices " + numberOfSidesOnEachDice + " sides each " + count + " times to get Yahtzee out of " +
                        totalPosibleCombinations + " total possible combinations");
        return count;
    }

    public static int[] rollDices(int numberOfDices, int numberOfSidesOnEachDice) {
        int[] dicesRoll = new int[numberOfDices];
        for (int i = 0; i < numberOfDices; i++) {
            dicesRoll[i] = rollDiceWithSides(numberOfSidesOnEachDice);
        }
        return dicesRoll;
    }

    public static boolean integersInArrayAreEqual(int[] dicesRoll) {
        int previousDiceRoll = -1;
        for (int i = 0; i < dicesRoll.length; i++) {
            int currentDiceRoll = dicesRoll[i];
            if (previousDiceRoll == -1 || currentDiceRoll == previousDiceRoll) {
                previousDiceRoll = currentDiceRoll;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static double factorial(double i) {
        if (i <= 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }

}
