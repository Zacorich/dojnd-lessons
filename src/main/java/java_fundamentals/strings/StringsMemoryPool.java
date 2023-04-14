package java_fundamentals.strings;

public class StringsMemoryPool {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        String c = "Hello";

        a = "Changed"; // new String object reference created and previous still exists as referenced by b and c ; meaning string are immutable;
        if(a == b){
            System.out.println("Same String object reference");
        }else{
            System.out.println("Different String objects references");
        }
    }
}
