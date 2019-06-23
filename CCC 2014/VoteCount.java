import java.util.*;

public class VoteCount {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numVotes = Integer.parseInt(in.nextLine());
        String[] votes = in.nextLine().split("");
        int A = 0;
        int B = 0;
        for (int i = 0; i < votes.length; i++){
            if (votes[i].equals("A")) { A++; }
            else if (votes[i].equals("B")) { B++; }
        }

        if (A == B) {System.out.println("Tie");}
        else { System.out.println( (A > B)? "A" : "B"); }
    }
}
