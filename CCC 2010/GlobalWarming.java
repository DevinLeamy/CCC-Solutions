//Problem 5 . Completed


import java.util.*;

public class GlobalWarming {

    public static int findShortestPath(int[] averages){
        int length = 1;
        while (true){
            ArrayList<Integer> differences = new ArrayList<>();
            if (averages.length == 0 || averages.length == 1) { return 0; }
            for (int i = 0; i < averages.length; i++){
                try {
                    differences.add(averages[i+1] - averages[i]);
                } catch (ArrayIndexOutOfBoundsException AIOOBE){
                    break;
                }
            }
            ArrayList<Integer> seq = new ArrayList<>();
            for (int i = 0; i < differences.size(); i++){
                try {
                    seq.add(differences.get(i % length));
                } catch (ArithmeticException AR){
                    seq.add(differences.get(i));
                }
            }
            boolean works = true;

            for (int i = 0; i < differences.size(); i++){
                if (differences.get(i).equals(seq.get(i))){
                    continue;
                } else {
                    works = false;
                    break;
                }
            }
            if (works) {
                return length;
            } else {
                length++;
            }

        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] averageString = in.nextLine().strip().split(" ");
        while (true){
            if (averageString[0].equals("0")){
                break;
            }
            int[] averages = new int[averageString.length - 1];
            for (int i = 0; i < averageString.length - 1; i++){
                averages[i] = Integer.parseInt(averageString[i + 1]);
            }
            System.out.println(findShortestPath(averages));
            averageString = in.nextLine().strip().split(" ");
        }
    }
}
