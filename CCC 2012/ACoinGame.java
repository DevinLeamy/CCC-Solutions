
import java.util.*;

public class ACoinGame {
    private static boolean deepContains(List<String[]> list, String[] probe) {
        for (String[] element : list) {
            if (Arrays.deepEquals(element, probe)) {
                return true;
            }
        }
        return false;
    }
    private static List<String[]>  moves(String[] initial){
        List<String[]> movesCurrent = new ArrayList<>(); //Holds the possible moves
        String[] hold = Arrays.copyOf(initial, initial.length); //Holds the initial configuration
        for (int i = 0; i < initial.length; i++){
            try {
                int stackOne = Integer.parseInt(String.valueOf(initial[i].charAt(0))); //Gets the value on top of the pile
                if (stackOne == 0){continue;} //Tries New Value
                int stackTwo = Integer.parseInt(String.valueOf(initial[i-1].charAt(0))); //Gets value on top of the pile to the left
                if (stackOne < stackTwo || stackTwo == 0){ //Checks whether a move is possible
                    if (stackTwo != 0) {
                        initial[i - 1] = stackOne + initial[i - 1]; //Puts lower value on top of the pile
                    } else {
                        initial[i-1] = stackOne + ""; //If zero, sets pile to be the lower value
                    }
                    if (initial[i].length() > 1){
                        initial[i] = initial[i].substring(1); //Removes the top value
                    } else {
                        initial[i] = "0"; //If pile was size 1, pile is set to 0
                    }
                    movesCurrent.add(initial); //Adds the configuration to the possible moves list
                    initial = Arrays.copyOf(hold, initial.length); //Sets initial to the initial configuration
                }
            } catch (ArrayIndexOutOfBoundsException aioobe){}
            try {
                int stackOne = Integer.parseInt(String.valueOf(initial[i].charAt(0))); //Does the same but checks pile to the right
                if (stackOne == 0){continue;}
                int stackTwo = Integer.parseInt(String.valueOf(initial[i+1].charAt(0)));
                if (stackOne < stackTwo || stackTwo == 0){
                    if (stackTwo != 0) {
                        initial[i + 1] = stackOne + initial[i + 1];
                    } else {
                        initial[i+1] = stackOne + "";
                    }
                    if (initial[i].length() > 1){
                        initial[i] = initial[i].substring(1);
                    } else {
                        initial[i] = "0";
                    }
                    movesCurrent.add(initial);
                    initial = Arrays.copyOf(hold, initial.length);
                }
            } catch (ArrayIndexOutOfBoundsException aioobe){}
        }
        return movesCurrent;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int numCoins = Integer.parseInt(in.nextLine()); //Number of Coins
            if (numCoins == 0){ break;} //End
            String[] initialOrder = in.nextLine().split(" ");
            String[] goal = Arrays.copyOf(initialOrder, numCoins);
            Arrays.sort(goal);
            //Goal == Desired State

            List<String[]> queue = new ArrayList<>();
            queue.add(initialOrder);
            String[] copyInitial = Arrays.copyOf(initialOrder, numCoins);
            //Adds the initial setup to the queue

            int counter = 0; //Counts the number of moves taken

            List<String> checked = new ArrayList<>(); //Record the moves (String[]'s) checked
            checked.add(Arrays.toString(copyInitial)); //Adds the initial order
            while (true){
                List<String[]> checkMoves;
                List<String[]> next = new ArrayList<>(); //holds the next values to be put in the queue
                if (deepContains(queue, goal)){ //End
                    System.out.println(counter);
                    break;
                }
                for (String[] set: queue) {
                    checkMoves = moves(set); //Hold the possible moves from a given position "set"
                    for (int i = 0; i < checkMoves.size(); i++) {
                        if (!checked.contains(Arrays.toString(checkMoves.get(i)))) { //Checks whether the move has already been checked
                            next.add(checkMoves.get(i));  //Adds the unchecked move to the next list and the checked list
                            checked.add(Arrays.toString(checkMoves.get(i)));
                        }
                    }
                }
                if (next.size() == 0){
                    System.out.println("IMPOSSIBLE");
                    break;
                }
                queue = new ArrayList<>();
                queue.addAll(next); //Initializes the new queue
                counter++;
            }
        }
    }
}
