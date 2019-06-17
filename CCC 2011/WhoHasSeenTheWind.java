import java.util.*;

public class WhoHasSeenTheWind {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int humidity = Integer.parseInt(in.nextLine());
        int maxTime = Integer.parseInt(in.nextLine());
        boolean landed = false;

        for (int i = 1; i < maxTime; i++){
            if (((-6 * (i * i * i * i) ) + (humidity * (i * i * i)) + (2 * (i * i)) + i) <= 0){
                System.out.println("The ballon first touches ground at hour:\n" +  i);
                landed = true;
                break;
            }
        }
        if (!landed){
            System.out.println("The ballon does not touch ground in the given time.");
        }
    }
}
