package intro_to_java.loops;

public class Pyramids {
    public static int countPyramidBlocks(int levels) {
        int total = 0;

        for (int i = 1; i <= levels; i++) {
            total += i * i;
        }
        System.out.println("Pyramid with " + levels + " levels has " + total + " blocks");
        return total;
    }
}
