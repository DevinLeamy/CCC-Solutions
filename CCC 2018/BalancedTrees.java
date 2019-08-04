import java.io.*;

public class BalancedTrees {
    private static long getSubtrees(long N, long[] subtrees, long count){
        long hold = count;
        for (int i = (int) N; i >= 2; i--){
            if (subtrees[(int) N / i] != 0){
                count += subtrees[(int)N / i];
            } else {
                count = getSubtrees(N / i, subtrees, count);
            }
        }
        subtrees[(int) N] = count - hold;
        return count;
    }
    private static long solve(long N) {
        long[] subtrees = new long[(int) N+1];
        try {
            subtrees[1] = 1;
            subtrees[2] = 1;
            subtrees[3] = 2;
            subtrees[4] = 3;
            subtrees[5] = 4;
            subtrees[6] = 6;
        } catch (ArrayIndexOutOfBoundsException aioobe){
            return subtrees[(int) N];
        }
        return getSubtrees(N, subtrees, 0);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(in.readLine());
        System.out.println(solve(N));
    }
}
