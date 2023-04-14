package intro_to_java.loops;

import intro_to_java.Utils;

public class Arrays {
    public static boolean pressConference(){
        String [] newsOutlets = {"abc", "bbc", "CNN", "CBS", "AP", "NBC", "FOX", "npr", "sky", "Aljazeera"};
        System.out.println(newsOutlets[Utils.rollDiceWithSides(newsOutlets.length-1)]);
        return true;
    }

    public static double calculateAverage(double [] temperatures){
        double total = 0.0;
        for(int i = 0 ; i < temperatures.length ; i++){
            total+=temperatures[i];
        }
        return total / temperatures.length;
    }

    public static double rubiksChampion(double [] speeds, boolean findWorst){
        double min = speeds[0];
        double max = speeds[0];
        for(int i = 1 ; i < speeds.length ; i++){
            if(speeds[i]<min){
                min = speeds[i];
            }
            if(speeds[i]>max){
                max = speeds[i];
            }
        }
        if(findWorst){
            return max;
        }else {
            return min;
        }
    }

    public static String findLongestName(String [] names){
        if(names.length > 0){
            String longestName = names[0];
            for(int i = 1 ; i < names.length ; i++){
                if(names[i].length()>longestName.length()){
                    longestName = names[i];
                }
            }
            return longestName;
        }

        return "";
    }

    public static double nestedLoopIterationForTwoDimensionalArray(double [][] grades){
        double total = 0;
        for(int i=0; i < grades.length ; i++){
            for(int j=0; j < grades[i].length ; j++){
                total += grades[i][j];
            }
        }
        return total;
    }
}
