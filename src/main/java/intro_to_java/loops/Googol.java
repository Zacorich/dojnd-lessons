package intro_to_java.loops;

public class Googol {
    public static String getGoogol(){
        String googol = "1";
        int len = googol.length();
        while(len <= 100){
            googol = googol + "0";
            len = googol.length();
            //System.out.println(len);
        }
        return googol;
    }
}
