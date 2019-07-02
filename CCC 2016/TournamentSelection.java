import java.util.*;

public class TournamentSelection {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int wins = 0;
        for (int i = 0; i < 6; i++){
            String line = in.nextLine();
            if (line.equals("W")){
                wins++;
            }
        }
        if (wins == 5||wins == 6){
            System.out.println(1);
        }
        else if (wins == 3||wins == 4){
            System.out.println(2);
        }
        else if (wins == 1||wins == 2){
            System.out.println(3);
        }
        else {
            System.out.println(-1);
        }

    }
}
