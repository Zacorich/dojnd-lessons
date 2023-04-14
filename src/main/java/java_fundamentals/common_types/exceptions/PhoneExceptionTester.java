package java_fundamentals.common_types.exceptions;

public class PhoneExceptionTester {
    public static void main(String[] args) {
        String [] numbers = {"123-4567", null, "223-4567", "323-4567"};
        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(new Phone("iPhone", numbers[i]));
            } catch (IllegalArgumentException e) {
                //Unchecked by compiler exception is caught which is also called runtime exception
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
}
