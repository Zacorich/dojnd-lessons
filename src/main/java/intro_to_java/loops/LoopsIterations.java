package intro_to_java.loops;

import intro_to_java.Utils;

public class LoopsIterations {
    public static int addNumbers() {
        int sum = 0;
        //body of the loop will run 20-15+1 + 1 = 7 times(for i<=20 check) and 6 times(for i<20 check)
        //first body execution without increment and last execution before last increment
        //when last increment is done the condition check is false so we don't step into the loop
        for (int i = 15; i <= 20; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Print even numbers from lowerLimit to upperLimit using loops increments
     *
     * @param lowerLimit limit from with to print even numbers(must be an even number)
     * @param upperLimit limit to witch to print even numbers(must be an even number)
     * @return even numbers from 0 to N
     */
    public static boolean stepFaster(int lowerLimit, int upperLimit) {
        if (lowerLimit % 2 != 0 || upperLimit % 2 != 0) {
            System.out.println("both limits must be even numbers");
            return false;
        }

        //print even number from 2 to upperLimit
        for (int i = lowerLimit; i < 0; i += 2) {
            System.out.println(i);
        }

        //zero is also an even number
        //https://en.wikipedia.org/wiki/Parity_of_zero
        System.out.println(0);

        //print even number from 2 to upperLimit
        for (int i = 2; i <= upperLimit; i += 2) {
            System.out.println(i);
        }
        return true;
    }

    public static boolean searchWifi() {
        boolean result = false;
        for (int i = 0; i <= 10; i++) {
            boolean wifiAvailable = checkWifi();
            if (wifiAvailable) {
                System.out.println("Wifi was found in " + i + " iteration");
                result = true;
                break;
            }
        }
        if (!result) {
            System.out.println("Wifi was not found");
            return false;
        } else {
            return true;
        }

    }

    /**
     * @return random true or false value
     */
    public static boolean checkWifi() {
        return Utils.randomBoolean();
    }

    /**
     * Rolls a dice till you get a 6  then you win
     * but if you get a 3 you loose
     *
     * @return true if someone won
     */
    public static boolean rollASix() {
        int roll = Utils.rollDiceWithSides(6);
        while (roll != 6) {
            if (roll == 3) {
                break;
            }
            roll = Utils.rollDiceWithSides(6);
        }
        if (roll == 3) {
            return false;
        }

        return true;
    }

    /**
     * If you keep wining you keep same bet amount and if you loose you double the bet with each loss
     * @param startAmount  money amount you start betting with
     * @param targetAmount money amount you consider as a win an leave the casion table
     * @param minBet       minimal bet at the casion table
     * @return amount of money I end up with after using this betting strategy
     */
    public static int martingale(int startAmount, int targetAmount, int minBet) {
        int totalBets = 0;
        int money = startAmount;
        int bet = minBet;
        while (money > minBet) {
            if (money >= targetAmount) {
                break;
            }
            boolean win = play();
            totalBets++;
            if (win) {
                //if we win we bet again with the same bet amount
                money += bet;
                //reset the bet to minimal bet at the casino table
                bet = minBet;
                System.out.println("You win :" + money);
            } else {
                money -= bet;
                bet *= 2;
                System.out.println("You loose and double the bet to : " + bet);
            }
        }
        System.out.println("You've made " + totalBets + " bets at the casino. Is there a better way to invest your time?");
        if(money < minBet) {
            System.out.println("You've lost all your money and you don't have any fill the minimal bet at the casino table");
        }else {
            System.out.println("You took home " + (money - startAmount) + " profit from the casion though." );
        }
        return money;
    }

    private static boolean play() {
        return Utils.randomBoolean();
    }
}
