import java.io.*;

public class FactorSolitaire {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        SolveFactorSolitaire solver = new SolveFactorSolitaire();
        System.out.println(solver.solve(N));
    }
}
class SolveFactorSolitaire{
    public static int solve(int N){
        int cost = 1;
        int current = N;
        if (current == 1){ return 0; }
        while (current != 2){
            while (current % 2 == 0) {
                current = current / 2;
                cost++;
                if (current == 2){ return cost; }
            }
            while (current % 3 == 0){
                int b = (current / 3);
                current = 2 * b;
                cost += 2;
                if (current == 2) { return cost; }

            }
            int max = (int) Math.sqrt((double) current);
            boolean F = false;
            for (int i = 2; i <= max; i++){
                if (current % i == 0){
                    int b = (current / i);
                    cost += (i - 1);
                    current = (i - 1) * b;
                    F = true;
                    break;
                }
            }
            if (current == 2){ return cost; }
            if (!F){
                current--;
                cost += current;
            }
        }
        return cost;
    }
}
