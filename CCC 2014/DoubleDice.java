import java.util.*;

public class DoubleDice {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numRounds = Integer.parseInt(in.nextLine());
        ArrayList<String> rounds = new ArrayList<>();

        for (int i = 0; i < numRounds; i++){
            rounds.add(in.nextLine());
        }

        int A = 100;
        int B = 100;

        for (String round: rounds){
            int aRoll = Integer.parseInt(round.split(" ")[0]);
            int bRoll = Integer.parseInt(round.split(" ")[1]);
            if (aRoll == bRoll) {continue;}
            if (aRoll < bRoll){ A -= bRoll; }
            else { B -= aRoll; }
        }
        System.out.println(A);
        System.out.println(B);


    }
}
