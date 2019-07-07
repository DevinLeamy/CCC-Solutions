// 7/15 On Online Grader because of Efficiency

import java.util.*;

public class RuleOfThree {
    private static String[] newArray(String original, ArrayList<String[]> arrays, String newString, int startIndex, int rule){
        if (arrays.size() > 0) {
            String[] output = new String[arrays.get(0).length + 1];
            for (String[] array : arrays) {
                if (array[array.length - 1].split(" ")[2].equals(original)) {
                    for (int i = 0; i < array.length; i++) {
                        output[i] = array[i];
                    }
                    output[output.length - 1] = rule + " " + (startIndex + 1) + " " + newString;

                    return output;
                }
            }
        }
        String[] output = new String[1];
        output[0] = rule + " " + (startIndex + 1) + " " + newString;
        return output;
    }
    private static void addValues(String original, String checkFor, String replaceWith, ArrayList<String> addHere, ArrayList<String[]> steps, int rule){
        try {
            for (int i = 0; i < original.length(); i++) {
                String sub = original.substring(i, i + checkFor.length());
                if (sub.equals(checkFor)) {
                    String newString = convert(i, i + checkFor.length(), replaceWith, original);
                    String[] step = newArray(original, steps, newString, i, rule);
                    addHere.add(newString);
                    steps.add(step);
                }
            }
        } catch (StringIndexOutOfBoundsException sioobe){}
    }
    private static String convert(int startIndex, int endIndex, String changeTo, String original){
        String output = "";
        for (int i = 0; i < original.length(); i++){
            if (i < endIndex && i >= startIndex){
                if (i == (endIndex - 1)) {
                    output += changeTo;
                }
            } else {
                output += String.valueOf(original.charAt(i));
            }
        }
        return output;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] ruleOne = in.nextLine().split(" ");
        String[] ruleTwo = in.nextLine().split(" ");
        String[] ruleThree = in.nextLine().split(" ");
        String[] values = in.nextLine().split(" ");
        int numMoves = Integer.parseInt(values[0]);
        String initial = values[1];
        String result = values[2];

        ArrayList<String[]> moves = new ArrayList<>();
        ArrayList<String> queue = new ArrayList<>();
        ArrayList<String> checked = new ArrayList<>();
        ArrayList<String> next = new ArrayList<>();
        checked.add(initial);
        queue.add(initial);
        int counter = 0;

        while (counter < numMoves){
            for (String value: queue){
                if (value.contains(ruleOne[0]) || value.contains(ruleTwo[0]) || value.contains(ruleThree[0])){
                    addValues(value, ruleOne[0], ruleOne[1], next, moves, 1);
                    addValues(value, ruleTwo[0], ruleTwo[1], next, moves, 2);
                    addValues(value, ruleThree[0], ruleThree[1], next, moves, 3);
                }
            }
            queue = new ArrayList<>();
            for (String go: next){
                if (!checked.contains(go)){
                    checked.add(go);
                    queue.add(go);
                }
            }
            next = new ArrayList<>();
            counter++;
            ArrayList<String[]> hold = new ArrayList<>();
            if (moves.size() > 0) {
                for (String[] array : moves) {
                    if (array.length == (counter - 1)) {
                        hold.add(array);
                    }
                }
            }
            moves.removeAll(hold);
        }
        for (String[] array: moves){
            if (array[array.length - 1].split(" ")[2].equals(result)){
                for (String step: array){
                    System.out.println(step);
                }
                break;
            }
        }
    }
}
