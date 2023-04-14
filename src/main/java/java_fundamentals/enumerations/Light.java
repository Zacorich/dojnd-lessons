package java_fundamentals.enumerations;

public class Light {
    public Light() {
    }
    public void changeLight(StopLight currentLight){
        if(currentLight == StopLight.GREEN){
            System.out.println("Green means GO!");
        }else if(currentLight == StopLight.YELLOW){
            System.out.println("Slow down!");
        }else if(currentLight == StopLight.RED){
            System.out.println("Stop!");
        }

    }
}
