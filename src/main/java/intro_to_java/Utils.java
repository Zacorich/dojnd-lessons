package intro_to_java;

public class Utils {
    public static int rollDiceWithSides(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public static double factorial(double i) {
        if (i <= 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
