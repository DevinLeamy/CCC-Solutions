import java.util.*;

public class RuleOfThree {
    private static boolean found = false;
    private static String getNewString(String original, int startIndex, int endIndex, String changeTo){
        String output = "";
        for (int i = 0; i < original.length(); i++){
            if (i == startIndex){
                output += changeTo;
                i = (endIndex - 1);
            } else{
                output += original.charAt(i);
            }
        }
        return output;
    }
    private static ArrayList<String> getMoves(String[] ruleOne, String[] ruleTwo, String[] ruleThree, String current){
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 0; i < current.length(); i++){
            try {
                String ruleOneSubString = current.substring(i, i + ruleOne[0].length());
                if (ruleOneSubString.equals(ruleOne[0])){
                    moves.add("1 " + i + " " + (i + ruleOne[0].length()) + " " + getNewString(current, i, i + ruleOne[0].length(), ruleOne[1]));
                }
            } catch (StringIndexOutOfBoundsException sioobe){}
            try {
                String ruleTwoSubString = current.substring(i, i + ruleTwo[0].length());
                if (ruleTwoSubString.equals(ruleTwo[0])){
                    moves.add("2 " + i + " " + (i + ruleTwo[0].length()) + " " + getNewString(current, i, i + ruleTwo[0].length(), ruleTwo[1]));
                }
            } catch (StringIndexOutOfBoundsException sioobe){}
            try {
                String ruleThreeSubString = current.substring(i, i + ruleThree[0].length());
                if (ruleThreeSubString.equals(ruleThree[0])){
                    moves.add("3 " + i + " " + (i + ruleThree[0].length()) + " " + getNewString(current, i, i + ruleThree[0].length(), ruleThree[1]));
                }
            } catch (StringIndexOutOfBoundsException sioobe){}
        }
        return moves;
    }
    private static void findSolution(String[] ruleOne, String[] ruleTwo, String[] ruleThree,
                                     String current, String desired, int movesTaken, int movesAllowed, String[] solution, ArrayList<String> visited){
        if (found){
            return;
        }
        if (movesTaken == movesAllowed){
            if (current.equals(desired)){
                for (String move: solution){
                    System.out.println(move);
                }
                found = true;
            }
            return;
        }
        visited.add(current + " " + movesTaken);
        ArrayList<String> moves = getMoves(ruleOne, ruleTwo, ruleThree, current);
        if (moves.size() > 0){
            for (String move: moves){
                String[] split = move.split(" ");
                if (!visited.contains(split[3] + " " + (movesTaken+1))) {
                    String addTo = split[0] + " " + (Integer.parseInt(split[1]) + 1) + " " + split[3];
                    solution[movesTaken] = addTo;
                    findSolution(ruleOne, ruleTwo, ruleThree, split[3], desired, movesTaken + 1, movesAllowed, solution, visited);
                    solution[movesTaken] = "";
                }
            }
        } else {
            return;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] ruleOne = in.nextLine().split(" ");
        String[] ruleTwo = in.nextLine().split(" ");
        String[] ruleThree = in.nextLine().split(" ");
        String[] values = in.nextLine().split(" ");
        String[] solution = new String[Integer.parseInt(values[0])];
        ArrayList<String> visited = new ArrayList<>();
        findSolution(ruleOne, ruleTwo, ruleThree, values[1], values[2], 0, Integer.parseInt(values[0]), solution, visited);
    }
}
