//Problem 5 . Completed

import java.util.*;

public class KnightHop {
//Gets the possible moves from current position
    public static ArrayList<String> possibleMove(int currentX, int currentY){
        ArrayList<Integer> range = new ArrayList<>();
        range.add(1); range.add(2); range.add(3); range.add(4); range.add(5);
        range.add(6); range.add(7); range.add(8);
        ArrayList<String> moves = new ArrayList<>();
        int[][] shifts = {{-1, 2}, {1, 2}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {-2, -1}, {-2, 1}};
        for (int[] pattern: shifts) {
            if (range.contains(currentX + pattern[0]) && range.contains(currentY + pattern[1])){
                moves.add((currentX + pattern[0]) + " " + (currentY + pattern[1]));
            }
        }
        //Returns ArrayList<String>
        return moves;
    }
    public static void main(String[] args)
    {
//Gets the start and end point
        Scanner in = new Scanner(System.in);
        String[] start = in.nextLine().split(" ");
        String end = in.nextLine();
        int startX = Integer.parseInt(start[0]);
        int startY = Integer.parseInt(start[1]);
//Checks if the start is equal to the end
        boolean startWhile = (startX == Integer.parseInt(end.split(" ")[0]) && startY == Integer.parseInt(end.split(" ")[1]))? false: true;
//Moves to compare to the end position
        ArrayList<String> toCheck = new ArrayList<>();
//Points that are checks, prevents repetition
        ArrayList<String> checked = new ArrayList<>();
//Fills toCheck with the possible moves from the starting position
        toCheck.addAll(possibleMove(startX, startY));
//Add the starting position to checked as it has been compared to the start value
        checked.add(startX + " " + startY);
//Records the distance travelled (in moves) from the start
        int counter = 0;
//If so print 0
        if (!startWhile){
            System.out.println(0);
        }
//Otherwise, start the while loop
        while (startWhile){
//A temporary ArrayList to hold collected values
            ArrayList<String> temp = new ArrayList<>();
//Variable to hold positions that have been checked
            ArrayList<String> toRemove = new ArrayList<>();
//If the moves to check contains the end, at one to the distance traveled, print distance and exit the loop
            if (toCheck.contains(end)) {
                System.out.println(++counter);
                break;
            }
//Adds the moves branching off of the moves in toCheck to the temporary variable
            for (String move: toCheck) {
                toRemove.add(move);
                checked.add(move);
                int moveX = Integer.parseInt(move.split(" ")[0]);
                int moveY = Integer.parseInt(move.split(" ")[1]);
                temp.addAll(possibleMove(moveX, moveY));
            }
//Removes all the checked values from the "moves to check" ArrayList
            toCheck.removeAll(toRemove);
//For the moves in the temporary variable, make them a move to check if they haven't been checked
            for (String newSeries: temp){
                if (!checked.contains(newSeries) && !toCheck.contains(newSeries)) {
                    toCheck.add(newSeries);
                }
            }
//Adds one to the distance traveled being that the circuit was completed
            counter++;

        }



    }
}
