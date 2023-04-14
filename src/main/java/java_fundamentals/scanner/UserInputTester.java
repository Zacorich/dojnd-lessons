package java_fundamentals.scanner;

import java.util.Scanner;

public class UserInputTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a String");
            String userInput = scanner.nextLine();
            System.out.println("User input: " + userInput);
        }catch (Exception e){
            e.getLocalizedMessage();
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }
}
