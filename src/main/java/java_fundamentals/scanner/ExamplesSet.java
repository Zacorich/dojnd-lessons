package java_fundamentals.scanner;

import java.util.Scanner;

public class ExamplesSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("This is a line");

        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        scanner = new Scanner("This is a line");
        System.out.println(scanner.next());

        scanner = new Scanner("This is a line");
        System.out.println(scanner.nextLine());
    }
}
