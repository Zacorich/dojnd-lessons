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
        if ((int) (Math.random() * 2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Rolls a dice till you get a 6  then you win
     * but if you get a 3 you loose
     * @return true if someone won
     */
    public static boolean rollASix(){
        int roll = Utils.rollDiceWithSides(6);
        while(roll != 6){
            if(roll == 3){
                break;
            }
            roll = Utils.rollDiceWithSides(6);
        }
        if(roll == 3){
            return false;
        }

        return true;
    }

    /**
     *
     * @return amount of money I end up with
     */
    public static int martingale(int startAmount, int targetAmount){

    }
}
