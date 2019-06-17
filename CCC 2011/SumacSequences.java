import java.util.*;

public class SumacSequences {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int startingValue = Integer.parseInt(in.nextLine());
        int secondValue = Integer.parseInt(in.nextLine());

        ArrayList<Integer> sumacSequence = new ArrayList<>();
        sumacSequence.add(startingValue);
        sumacSequence.add(secondValue);

        int current = 1;

        while (sumacSequence.get(current) < sumacSequence.get(current - 1)){
            sumacSequence.add(sumacSequence.get(current - 1) - sumacSequence.get(current));
            current++;
        }
        System.out.println(sumacSequence.size());
    }
}
