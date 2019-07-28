import java.io.*;

public class PrettyAveragePrimes {
    private static boolean isPrime(int N){
        int max = (int) Math.sqrt(N) + 1;
        for (int i = 2; i < max; i++){
            if (N % i == 0){
                return true;
            }
        }
        return false;
    }
    private static int[] findPrimes(int N){
        int[] output = new int[2];
        if (N % 2 == 0){
            N--;
            output[0] = N;
            output[1] = N + 2;
        } else {
            output[0] = N;
            output[1] = N;
        }
        while (isPrime(output[0]) || isPrime(output[1])){
            output[0] -= 2;
            output[1] += 2;
        }
        return output;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(in.readLine());
            int[] output = findPrimes(N);
            System.out.println(output[0] + " " + output[1]);
        }
    }
}
