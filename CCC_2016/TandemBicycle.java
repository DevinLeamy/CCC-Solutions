import java.util.*;

public class TandemBicycle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int question = Integer.parseInt(in.nextLine());
        int numPeople = Integer.parseInt(in.nextLine());
        StringTokenizer A = new StringTokenizer(in.nextLine());
        StringTokenizer B = new StringTokenizer(in.nextLine());
        int[] AP = new int[numPeople];
        int[] BP = new int[numPeople];

        for (int i = 0; i < numPeople; i++){
            AP[i] = Integer.parseInt(A.nextToken());
            BP[i] = Integer.parseInt(B.nextToken());
        }
        Arrays.sort(AP);
        Arrays.sort(BP);
        switch (question){
            case 2:
                int max = 0;
                for (int i = 0; i < numPeople; i++){
                    max += Integer.max(AP[i], BP[numPeople - i - 1]);
                }
                System.out.println(max);
                break;
            case 1:
                int min = 0;
                for (int i = 0; i < numPeople; i++){
                    min += Integer.max(AP[i], BP[i]);
                }
                System.out.println(min);
                break;
        }
    }
}
