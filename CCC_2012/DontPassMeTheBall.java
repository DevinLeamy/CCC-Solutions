import java.util.*;

public class DontPassMeTheBall {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int counter = 0;
        for(int i = 3; i < num; i++){
            for (int x = 2; x < num-1; x++){
                for (int y = 1; y< num-2; y++){
                    if (i > x && x > y){
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
