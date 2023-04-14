package java_fundamentals.strings;

public class StringMethods {
    public static void main(String[] args) {
        String text = "Hello";
        System.out.println(text.charAt(2));
        System.out.println(text.equalsIgnoreCase("hello"));
        System.out.println(text.contains("e"));
        String commaSeparatedString = "This, is, a, comma, separated, list ";
        String[] stringArray = commaSeparatedString.split(",");
        for (int i = 0; i < stringArray.length; i++) {
            String s = stringArray[i];
            System.out.println(s.trim());
        }

        System.out.println(commaSeparatedString.substring(0, 4));//ending index is exclusive

        System.out.println(text.replace("l", "2"));
    }
}
