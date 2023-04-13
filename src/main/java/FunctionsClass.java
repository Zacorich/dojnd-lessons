public class FunctionsClass {
    public static int rollDice(){
        double randomNumber = Math.random() * 6;
        randomNumber += 1;
        return (int) randomNumber;
    }
    public static void main(String[] args) {

        System.out.println(rollDice());
        System.out.println(rollDice());
    }
}
