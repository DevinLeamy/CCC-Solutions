//Problem 5 . Completed

import java.util.*;

public class KnightHop {
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
        return moves;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] start = in.nextLine().split(" ");
        String end = in.nextLine();
        int startX = Integer.parseInt(start[0]);
        int startY = Integer.parseInt(start[1]);
        boolean startWhile = (startX == Integer.parseInt(end.split(" ")[0]) && startY == Integer.parseInt(end.split(" ")[1]))? false: true;
        ArrayList<String> toCheck = new ArrayList<>();
        ArrayList<String> checked = new ArrayList<>();
        toCheck.addAll(possibleMove(startX, startY));
        checked.add(startX + " " + startY);
        int counter = 0;
        if (!startWhile){
            System.out.println(0);
        }
        while (startWhile){
            ArrayList<String> temp = new ArrayList<>();
            ArrayList<String> toRemove = new ArrayList<>();
            if (toCheck.contains(end)) {
                System.out.println(++counter);
                break;
            }
            for (String move: toCheck) {
                toRemove.add(move);
                checked.add(move);
                int moveX = Integer.parseInt(move.split(" ")[0]);
                int moveY = Integer.parseInt(move.split(" ")[1]);
                temp.addAll(possibleMove(moveX, moveY));
            }
            toCheck.removeAll(toRemove);
            for (String newSeries: temp){
                if (!checked.contains(newSeries) && !toCheck.contains(newSeries)) {
                    toCheck.add(newSeries);
                }
            }
            counter++;
        }
    }
}
