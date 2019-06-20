import java.util.*;

public class SoundsFishy {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int first = Integer.parseInt(in.nextLine());
        int second = Integer.parseInt(in.nextLine());
        int third = Integer.parseInt(in.nextLine());
        int forth = Integer.parseInt(in.nextLine());
        if (first == second){
            if (second == third && third == forth){
                System.out.println("Fish At Constant Depth");
            } else {
                System.out.println("No Fish");
            }
        } else if (first > second){
            if (second > third && third > forth){
                System.out.println("Fish Diving");
            } else {
                System.out.println("No Fish");
            }
        } else if (first < second) {
            if (second < third && third < forth){
                System.out.println("Fish Rising");
            } else {
                System.out.println("No Fish");
            }
        }
    }
}
