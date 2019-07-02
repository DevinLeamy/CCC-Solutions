import java.util.*;

public class TandemBicycle {
    private static int findMin(int[] D, int[] P, int N){
        Arrays.sort(D);
        Arrays.sort(P);
        int total = 0;
        for (int i = 0; i < N; i++) {
            int personD = D[i];
            int personP = P[i];
            total += (personD >= personP)? personD: personP;
        }
        return total;
    }
    private static int findMax(int[] D, int[] P, int N){
        Arrays.sort(D);
        Arrays.sort(P);
        int total = 0;
        for (int i = 0; i < N; i++) {
            int personD = D[i];
            int personP = P[P.length - 1 - i];
            total += (personD >= personP)? personD: personP;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int question = Integer.parseInt(in.nextLine());
        int numPeople = Integer.parseInt(in.nextLine());
        int[] D = new int[numPeople];
        int[] P = new int[numPeople];
        String[] inputD = in.nextLine().split(" ");
        String[] inputP = in.nextLine().split(" ");

        for (int i = 0; i < numPeople; i++){
            D[i] = Integer.parseInt(inputD[i]);
            P[i] = Integer.parseInt(inputP[i]);
        }


        switch (question){
            case 1:
                System.out.println(findMin(D, P, numPeople));
                break;
            case 2:
                System.out.println(findMax(D, P, numPeople));
                break;
        }
    }
}
