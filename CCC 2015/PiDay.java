//Scores 13/15 on the Online Grader due to Efficency 

import java.util.*;

public class PiDay {
    private static int givePie(int pieces, int people, int given, int served, int counter, int lastPiece){
        if (pieces == given && served == people){
            counter++;
            return counter;
        } else if (served == people){
            return counter;
        }
        int max = ((pieces - given) / (people - served));
        for (int i = lastPiece; i < (max + 1); i++){
            counter = givePie(pieces, people, given + i, served + 1, counter, i);
        }
        return counter;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine());
        int people = Integer.parseInt(in.nextLine());
        System.out.println(givePie(pieces, people, 0, 0, 0, 1));


    }
}
