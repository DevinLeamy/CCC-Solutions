//Problem 5 . Completed


import java.util.*;

public class GlobalWarming {

    public static int findShortestPath(int[] averages){
        int length = 1;
        while(true){
            int counter = 0;
            ArrayList<Integer> differences = new ArrayList<>();
            if (averages.length == 0){ return 0;}
            for (int i = 0; i < averages.length; i++){
                try{
                    differences.add((averages[i] - averages[i+1]) * -1);
                } catch (ArrayIndexOutOfBoundsException AIOOBE){
                    break;
                }
            }
            ArrayList<Integer> seq = new ArrayList<>();
            for (int i = 0; i < differences.size(); i++){
                seq.add(differences.get(i % length));
            }
            Set<Integer> unique = new HashSet<>(differences);
            if (unique.size() == 1){
                return 1;
            } else if (unique.size() == differences.size()){
                return differences.size();
            }
            for (int i = 0; i < differences.size(); i++){
                if (differences.get(i) == seq.get(i)){
                    continue;
                } else{
                    counter++;
                }
            }
            if (counter == 0){
                return length;
            }
            length++;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String[] raw = in.nextLine().strip().split(" ");

        int[] averages = new int[raw.length - 1];

        for (int i = 0; i < raw.length - 1; i++){
            try {
                averages[i] = Integer.parseInt(raw[i + 1]);
            } catch (ArrayIndexOutOfBoundsException AIOOBE){
                break;
            }
        }

        while (true){
            System.out.println(findShortestPath(averages));
            raw = in.nextLine().split(" ");
            boolean stop = false;
            if (raw[0].equals("0")) {
                in.close(); stop = true;}
            if (stop) {break;}

            averages = new int[raw.length - 1];

            for (int i = 0; i < raw.length - 1; i++){
                try {
                    averages[i] = Integer.parseInt(raw[i + 1]);
                } catch (ArrayIndexOutOfBoundsException AIOOBE){
                    break;
                }
            }
        }

    }
}
