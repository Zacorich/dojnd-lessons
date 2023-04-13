package intro_to_java.variables_and_data_types;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProblemSet1 {
    public void question1(){
        // following statement will raise compilation error, because String data type
        // initial value must be enclosed in double quotes characters. char datatype
        // excepts single character enclosed in single quotes.
        // String name = 'Adam';
    }

    public void question2(){
        double register = 10.0;
        register = register + 5; // Customer pays $5.
        register = register - 2.5; // Customer receives $2.50 as change.
        register = register + 10; // Customer pays $10.
        register = register - 3; // Customer receives $3 as change.
        System.out.println(register);
    }

    public void question3() {
        int bankBalance = 500;
        // bankBalance += 250;
        bankBalance = bankBalance + 250;
        // bankBalance -= 100;
        bankBalance = bankBalance - 100;
        System.out.println(bankBalance);
    }

    public void question4(){
        // Following statement will print 4.0, because parentheses will prioritise 5/2
        // which will
        // produce integer 2 by droping any fraction(truncation) because there is no any
        // double value present in the devision. Then 2.0(double) gets multiplied by
        // 2(int) which will produce double value of 4.0.
        System.out.println(2.0 * (5 / 2));
    }

    public void question5(){
        int day = 30;
        String month = "April";

        // Question 6:
        String firstName = "Constantin";
        String lastName = "Zagorsky";
        String fullName = firstName + " " + lastName;
        System.out.println(
                "Hello, my name is " + fullName +
                        ".\nThere are " +
                        (firstName.length() + lastName.length()) + " letters in my name.");
    }

    public void question7(){
        double fahrenheit = 7;
        double celsius = (7 - 32) * 5.0 / 9.0;
        System.out.println(fahrenheit + " F = " + celsius + " C");
        //same result as Chat GPT
        System.out.println(fahrenheit + " F = " +
                new BigDecimal(celsius).setScale(2, RoundingMode.HALF_UP) + " C");
    }
}
